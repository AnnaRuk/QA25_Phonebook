package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        // user
        if (!app.getUserHelper().isLoginLinkPresent()){
            app.getUserHelper().clickOnSignOutButton();}
        // click on a:nth-child(4) - css
        app.getUserHelper().login();
        //click on ADD link
        app.getContactHelper().addContact();

    }

    @Test
    public void removeContactPositiveTest(){
        int sizeBefore = app.getContactHelper().sizeOfContacts();
        //click on contact card = .contact-item_card__2SOIM
        app.getContactHelper().removeContact();
        // assert contact is removed
        app.getContactHelper().pauseSelenium(1000);
        int sizeAfter = app.getContactHelper().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }


}
