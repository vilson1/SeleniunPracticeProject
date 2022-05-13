package com.cydeo.tests.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_StaleElementReferenceExeption {
    public static void main(String[] args) {
       // TC #6: StaleElementReferenceException Task
       // 1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

       // 2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

       // 3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoElement=driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("cydeoElement.isDisplayed(), expected result true  = " + cydeoElement.isDisplayed());
        // 4- Refresh the page.
        driver.navigate().refresh();
       // 5- Verify it is displayed, again.
        cydeoElement=driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println("cydeoElement.isDisplayed(), expected result true = " + cydeoElement.isDisplayed());
    }
}
