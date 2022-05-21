package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void T1_alert_Test(){
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts ");
//        3. Click to “Click for JS Alert” button
        WebElement buttonOfJSAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buttonOfJSAlert.click();
//        4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
//        5. Verify “You successfully clicked an alert” text is displayed.
        WebElement result=driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));

        String expectedResult="You successfully clicked an alert";
        String actualResult=result.getText();


        Assert.assertTrue(result.isDisplayed(),"Message is not Displayed");
        Assert.assertEquals(actualResult,expectedResult,"Actual result is not exepted");


    }
}
