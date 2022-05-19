package com.cydeo.homeworkTasks.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_XPathLocator {
    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");
//        3. Click on Button 1
        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();
//        4. Verify text displayed is as expected:
//        Expected: “Clicked on button one!”
        WebElement diplayedText=driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResult="Clicked on button one!";
        String actualResult=diplayedText.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
    }
}
