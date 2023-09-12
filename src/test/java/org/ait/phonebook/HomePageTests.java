package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHomePageHelper().isHomeComponentPresent()){
            app.getHomePageHelper().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest(){
       // isHomeComponentPresent();
       // System.out.println("Home Component is " + isHomeComponentPresent());
       // System.out.println("Home Component is " + isElementPresent(By.xpath("//h1[text()='Home Component']")));
       // System.out.println("Home Component is " + isElementPresent2(By.xpath("//h1[text()='Home Component']")));

        Assert.assertTrue(app.getHomePageHelper().isHomeComponentPresent());


//h1[text()='Home Component']
//div:nth-child(2)>div>div
//div[2]/div/div
    }


}
