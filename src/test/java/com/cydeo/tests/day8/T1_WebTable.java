package com.cydeo.tests.day8;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void T1_order_name_verify_test(){
//        1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
//        2. Verify Bob’s name is listed as expected.
        WebElement bobMartinText=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        Assert.assertTrue(bobMartinText.getText().equals("Bob Martin"));
//        Expected: “Bob Martin”
//        3. Verify Bob Martin’s order date is as expected
        WebElement orderDate=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertTrue(orderDate.getText().equals("12/31/2021"));
//        Expected: 12/31/2021
    }

    @Test

    public void T2_order_name_verify_test(){
        driver.get("https://practice.cydeo.com/web-tables");
        System.out.println("WebTableUtils.returnOrderDate(driver,\"Alexandra Gray\") = " + WebTableUtils.returnOrderDate(driver, "Alexandra Gray"));
    }

    @Test
    public void T3(){
        driver.get("https://practice.cydeo.com/web-tables");
        WebTableUtils.orderVerify(driver,"Alexandra Gray","04/15/2021");
    }
}
