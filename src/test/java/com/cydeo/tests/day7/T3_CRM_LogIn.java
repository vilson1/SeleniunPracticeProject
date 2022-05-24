package com.cydeo.tests.day7;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LogIn {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //        1. Create a new class called: T4_Iframes
//        2. Create new test and make set ups
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void T3_Crm_LogInTest(){
//        1. Create new test and make set ups
//        2. Go to : http://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com ");
//        3. Enter valid username
        WebElement username=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");
//        4. Enter valid password
        WebElement password=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
//        5. Click to `Log In` button
        WebElement logInButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();
//        6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver,"Portal");
//        Expected: Portal
    }

    @Test
    public void T3_Crm_LogInTest_2(){
//        1. Create new test and make set ups
//        2. Go to : http://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com ");

        CRM_Utilities.CRM_Login(driver);
//        6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver,"Portal");
//        Expected: Portal
    }

    @Test
    public void T3_Crm_LogInTest_3(){
//        1. Create new test and make set ups
//        2. Go to : http://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com ");

        CRM_Utilities.CRM_Login(driver, "Helpdesk2@cybertekschool.com","UserUser");
//        6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver,"Portal");
//        Expected: Portal
    }
}
