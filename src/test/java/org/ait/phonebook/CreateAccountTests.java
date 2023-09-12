package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    //click on Login link
    //enter email
    //enter password
    //click on Registration button
    //assert Sign out button displayed

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUserHelper().isLoginLinkPresent()){
            app.getUserHelper().clickOnSignOutButton();
        }
        app.getUserHelper().clickOnLoginLink();
    }

    // @Test
//    public void newUserRegistrationPositiveTest(){
//        //[placeholder='Email']  - css
//        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
//        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
//        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("anna80@gmail.com");
//        //[placeholder='Password'] - css
//        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
//        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
//        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Qwerty007$");
//        //  //button[text()='Registration'] - xpath
//        driver.findElement(By.xpath("//button[text()='Registration']")).click();
//        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
//    }

    @Test
    public void existedRegistrationNegativeTest(){
        app.getUserHelper().fillLoginRegstrationForm(new User().setEmail("anna80@gmail.com").setPassword("Qwerty007$"));
        app.getUserHelper().clickOnRegistrationButton();
        Assert.assertTrue(app.getContactHelper().isAlertPresent());
    }


}
