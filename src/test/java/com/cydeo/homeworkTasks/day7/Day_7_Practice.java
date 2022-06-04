package com.cydeo.homeworkTasks.day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day_7_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void T1_windowHandlePractice(){
//        1. Create new test and make set ups
//        2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com ");
//        3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

//        4. Create a logic to switch to the tab where Etsy.com is open

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

//        5. Assert: Title contains “Etsy”
        Assert.assertTrue(driver.getTitle().contains("Etsy"));
    }

    @Test
    public void T2_LogInSenario(){
//        1. Create new test and make set ups
//        2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com");
//        3. Enter valid username
        WebElement username=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com ");
//        4. Enter valid password
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
//        5. Click to `Log In` button
        WebElement clickButton=driver.findElement(By.xpath("//input[@type='submit']"));
        clickButton.click();
//        6. Verify title is as expected:
        Assert.assertTrue(driver.getTitle().equals("Portal"));
//        Expected: Portal
    }



}
