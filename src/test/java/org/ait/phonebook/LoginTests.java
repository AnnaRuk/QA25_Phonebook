package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUserHelper().isLoginLinkPresent()){   //a:nth-child(4)
            app.driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
        // click on a:nth-child(4) - css
        app.driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }

    @Test
    public void loginPositiveTest(){
//[placeholder='Email']  - css
        app.getUserHelper().fillLoginRegstrationForm(new User().setEmail("anna80@gmail.com").setPassword("Qwerty007$"));
        //click on login button
        app.getUserHelper().clickOnLoginButton();
        //assert Sign Out locator present
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        //[placeholder='Email']  - css
        app.getUserHelper().fillLoginRegstrationForm(new User().setPassword("Qwerty007$"));
        //click on login button
        app.getUserHelper().clickOnLoginButton();
        //assert Sign Out locator present
        Assert.assertTrue(app.getUserHelper().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
    app.getUserHelper().deleteScreencast();
        app.getUserHelper().startRecording();
        app.getUserHelper().fillLoginRegistrationFormScreencat(new User()
                .setEmail("anna80@gmail.com")
                .setPassword("Qwerty007$"));
        app.getUserHelper().clickOnLoginButton();
        app.getUserHelper().pauseSelenium(2000);
       app.getUserHelper().stopRecording();
    }


}
