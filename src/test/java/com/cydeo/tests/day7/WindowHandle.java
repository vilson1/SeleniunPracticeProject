package com.cydeo.tests.day7;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowHandle {


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
    public void T1_windowHandle(){

//            1. Create new test and make set ups
//            2. Go to : https://www.amazon.com
            driver.get("https://www.amazon.com");
//            3. Copy paste the lines from below into your class
//            Lines to be pasted:

            ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


//            4. Create a logic to switch to the tab where Etsy.com is open
            BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");

        }

}
