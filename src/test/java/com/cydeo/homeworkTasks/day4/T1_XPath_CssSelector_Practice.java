package com.cydeo.homeworkTasks.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_XPath_CssSelector_Practice {
    public static void main(String[] args) {
//        TC #1: XPATH and cssSelector Practices
//        1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
//        3. Locate all the WebElements on the page using XPATH and/or CSS
//        locator only (total of 6)
//        a. “Home” link
        WebElement homeLink=driver.findElement(By.cssSelector("a[class='nav-link']"));
//        b. “Forgot password” header
        WebElement forgotPasswordHeader=driver.findElement(By.cssSelector("div>h2"));
//        c. “E-mail” text
        WebElement emailText=driver.findElement(By.cssSelector("label[for='email']"));
//        d. E-mail input box
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@name='email']"));
//        e. “Retrieve password” button
        WebElement retrivePassword=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
//        f. “Powered by Cydeo text
        WebElement powerdByC=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
//        4. Verify all web elements are displayed.
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("retrivePassword.isDisplayed() = " + retrivePassword.isDisplayed());
        System.out.println("powerdByC.isDisplayed() = " + powerdByC.isDisplayed());
//        First solve the task with using cssSelector only. Try to create 2 different
//        cssSelector if possible
//
//        Then solve the task using XPATH only. Try to create 2 different
//        XPATH locator if possible
    }
}
