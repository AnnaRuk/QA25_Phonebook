package org.ait.phonebook.fw;

import org.ait.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddElement() {
          click(By.cssSelector("[href='/add']"));
      }

    public void clickOnSaveButton() {
          click(By.cssSelector(".add_form__2rsm2 button"));
      }

    public void fillContactForm(Contact contact) {
          type(By.cssSelector("input:nth-child(1)"), contact.getName()); //name
          type(By.cssSelector("input:nth-child(2)"), contact.getSurname()); //Lastname
          type(By.cssSelector("input:nth-child(3)"), contact.getPhoneNumber()); //phone
          type(By.cssSelector("input:nth-child(4)"), contact.getEmail()); //email
          type(By.cssSelector("input:nth-child(5)"), contact.getAddress()); //address
          type(By.cssSelector("input:nth-child(6)"), contact.getDiscription()); //discription
      }

    public boolean isContactAdded(String text){
         List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
         for (WebElement contact: contacts
              ) {
             if (contact.getText().contains(text));
             return true;

         }
         return false;
     }

    public void removeContact() {
         click(By.cssSelector(".contact-item_card__2SOIM"));
         click(By.xpath("//button[.='Remove']"));
     }

    public int sizeOfContacts(){
         if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
             return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
         }
         return 0;
     }

    public void addContact() {
         clickOnAddElement();
         fillContactForm(new Contact().setName("anna")
                 .setSurname("bel")
                 .setPhoneNumber("1234567890")
                 .setEmail("anna@gmail.com")
                 .setAddress("RobertPlaz 3, 01023")
                 .setDiscription("anna anna"));
         //click on Save button   .add_form__2rsm2 button
         clickOnSaveButton();
     }
}
