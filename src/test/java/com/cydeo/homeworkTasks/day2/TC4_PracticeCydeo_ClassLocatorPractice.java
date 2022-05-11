package com.cydeo.homeworkTasks.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4_PracticeCydeo_ClassLocatorPractice {
    public static void main(String[] args) {
        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement homeWebElement=driver.findElement(By.className("nav-link"));
        homeWebElement.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Web page title verification TC Passed");
        }else {
            System.out.println("Web page title verification TC Failed");
        }
        driver.close();


        //PS: Locate “Home” link using “className” locator
    }
}
