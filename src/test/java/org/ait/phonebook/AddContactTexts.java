package org.ait.phonebook;

import org.ait.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTexts extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        // user
        if (!app.getUserHelper().isLoginLinkPresent()){
            app.getUserHelper().clickOnSignOutButton();
        }
        // click on a:nth-child(4) - css
        app.getUserHelper().login();
        //click on ADD link
        app.getContactHelper().clickOnAddElement();
    }

    @Test
    public void addContactPositiveTest(){


        //enter all fields in contact form     input:nth-child(1)
        app.getContactHelper().fillContactForm(new Contact().setName("anna")
                .setSurname("bel")
                .setPhoneNumber("1234567890")
                .setEmail("anna@gmail.com")
                .setAddress("RobertPlaz 3, 01023")
                .setDiscription("anna anna"));
        //click on Save button   .add_form__2rsm2 button
        app.getContactHelper().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContactHelper().isContactAdded("anna"));

    }


    @AfterMethod
    public void postCondition(){
        app.getContactHelper().removeContact();
    }

    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver1","Oliver Twist", "1243500000567","hty@lkfjlkdf.juh","Berlin","kfje"});
        list.add(new Object[]{"Oliver2","Oliver Twist", "124358686987","hty@lkfjlkdf.juh","Berlin","kfje"});
        list.add(new Object[]{"Oliver3","Oliver Twist", "1243534352627", "hty@lkfjlkdf.juh","Berlin","kfje"});
        return list.iterator();
    }

    @Test(dataProvider = "newContact")
    public void addContactPositiveTestFromDataProvider(String name,
                                                       String surname, String phone, String email, String address, String description){

        app.getContactHelper().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhoneNumber(phone)
                .setEmail(email)
                .setAddress(address)
                .setDiscription(description));
        app.getContactHelper().clickOnSaveButton();

        Assert.assertTrue(app.getContactHelper().isContactAdded(name));

    }
    @DataProvider
    public Iterator<Object[]> newContactWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));


        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSurname(split[1]).setPhoneNumber(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDiscription(split[5])});
            line = reader.readLine();
        }


        return list.iterator();
    }

    @Test(dataProvider = "newContactWithCSVFile")
    public void addContactPositiveTestFromDataProviderWithSCV(Contact contact){

        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().clickOnSaveButton();

        Assert.assertEquals(Integer.toString(app.getContactHelper().sizeOfContacts()),
                "1");

    }
}
