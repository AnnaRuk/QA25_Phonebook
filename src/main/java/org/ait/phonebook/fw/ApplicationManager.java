package org.ait.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    public WebDriver driver;

    UserHelper userHelper;
    ContactHelper contactHelper;
    HomePageHelper homePageHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        System.err.close();

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
            driver = new EdgeDriver();
        }

        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(driver);
        contactHelper = new ContactHelper(driver);
        homePageHelper = new HomePageHelper(driver);


    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public void stop() {
         driver.quit();
     }

}
