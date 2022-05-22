package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {
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
    public void T5_windowHandle(){
//        1. Create a new class called: T5_WindowsPractice
//        2. Create new test and make set ups
//        3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
        String mainHandle=driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
//        4. Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(),"Windows");
//        5. Click to: “Click Here” link
        WebElement clickButton=driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickButton.click();
//        6. Switch to new Window.
        for(String each: driver.getWindowHandles()){
            driver.switchTo().window(each);

        }
//        7. Assert: Title is “New Window”
        Assert.assertEquals(driver.getTitle(),"New Window");
    }
}
