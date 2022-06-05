package com.cydeo.tests.day8;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigPractice {
//
//    WebDriver driver;
//    @BeforeMethod
//    public void setUpMethod(){
//
//        String browser= ConfigurationReader.getProperty("browser");
//
//        driver= WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @Test
    public void T4_configPractice(){
//        1- Open a chrome browser
//        2- Go to: https://google.com
        Driver.getDriver().get("https://google.com");
//        3- Write “apple” in search box
        WebElement searchBox=Driver.getDriver().findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("apple"+ Keys.ENTER);


//        4- Verify title:
//        Expected: apple - Google Search
        Assert.assertEquals(Driver.getDriver().getTitle(),"apple - Google Search");
    }
}
