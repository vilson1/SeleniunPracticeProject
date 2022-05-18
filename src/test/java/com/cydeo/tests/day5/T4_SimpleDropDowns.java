package com.cydeo.tests.day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropDowns {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){


        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void simpleDropDownTest(){


        // 3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropDown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption=simpleDropDown.getFirstSelectedOption();

        String actualSimpleDropDownText=currentlySelectedOption.getText();
        String expectedSimpleDropDownList="Please select an option";
        Assert.assertEquals(actualSimpleDropDownText,expectedSimpleDropDownList);

        // 4. Verify “State selection” default selected value is correct
        // Expected: “Select a State”

        Select stateDropDown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expectedStateDropDown="Select a State";
        String actualStateDropDown=stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedStateDropDown,actualStateDropDown);

    }
}
