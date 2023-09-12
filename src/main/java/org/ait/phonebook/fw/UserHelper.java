package org.ait.phonebook.fw;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class UserHelper extends HelperBase{


    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
         click(By.xpath("//a[.='LOGIN']"));
     } //By.xpath("//a[.='LOGIN']")

    public void clickOnSignOutButton() {
         click(By.xpath("//button[contains(.,'Sign Out')]"));
     }

    public boolean isLoginLinkPresent() {
         return isElementPresent(By.xpath("//a[.='LOGIN']"));
     }

    public void clickOnRegistrationButton() {
         click(By.xpath("//button[text()='Registration']"));
     }

     //TODO mistake
    public void fillLoginRegstrationForm(User user) {
         type(By.cssSelector("[placeholder='Email']"), user.getEmail());
         //[placeholder='Password'] - css
         type(By.cssSelector("[placeholder='Password']"), user.getPassword());
         //  //button[text()='Registration'] - xpath
     }

    public boolean isSignOutButtonPresent() {
         return isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]"));
     }

    public void clickOnLoginButton() {
         click(By.xpath("//button[.='Login']"));
     }

    public void login() {
        clickOnLoginLink();
         //type = filling field
         fillLoginRegstrationForm(new User().setEmail("anna80@gmail.com").setPassword("Qwerty007$"));
         clickOnLoginButton();
     }

     public void fillLoginRegistrationFormScreencat(User user){
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        pauseSelenium(500);
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
        pauseSelenium(1000);
     }
}
