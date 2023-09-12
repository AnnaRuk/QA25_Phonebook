package org.ait.phonebook;

import org.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void SetUp(){
        app.init();
    }


    @AfterSuite(enabled=true)
    //@AfterMethod()
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m){
        //logger.info("Start test");
        logger.info("Start test " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED:" + result.getMethod().getMethodName()
            + "Screenshot: " + app.getUserHelper().takeScreenshot());
        }

        logger.info("Stop test");
        logger.error("*******************");

    }

}
