package com.cydeo.tests.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Cssselector_XPath_Practice {
    public static void main(String[] args) {
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/forgot_password");
        //2. Go to https://practice.cydeo.com/forgot_password
        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link

        WebElement homeLink=driver.findElement(By.cssSelector("a[class='nav-link']"));


        //b. “Forgot password” header
        WebElement forgotPasswordElement=driver.findElement(By.cssSelector("div>h2"));

        //c. “E-mail” text
        WebElement emailLabel=driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@type='text']"));

        //e. “Retrieve password” button
        WebElement retrivePassword1=driver.findElement(By.xpath("//button[@class='radius']"));

        //f. “Powered by Cydeo text

        WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordElement = " + forgotPasswordElement.isDisplayed());
        System.out.println("emailLabel = " + emailLabel.isDisplayed());
        System.out.println("emailInputBox = " + emailInputBox.isDisplayed());
        System.out.println("retrivePassword1 = " + retrivePassword1.isDisplayed());
        System.out.println("poweredByCydeoText = " + poweredByCydeoText.isDisplayed());

        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible



    }
}
