package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {
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
    public void T1_iFrame(){

//        3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
//        4. Assert: “Your content goes here.”
        driver.switchTo().frame("mce_0_ifr");
        WebElement contentGoesHereText=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(contentGoesHereText.isDisplayed());

//        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        WebElement header=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(header.isDisplayed());

    }
}
