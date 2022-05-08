package com.cydeo.tests.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_ResetPasswordButtonText {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        WebElement resetButton=driver.findElement(By.cssSelector("button[class='login-btn']"));

        String expectedPassword="Reset password";
        String actualPassword=resetButton.getText();

        if (expectedPassword.equals(actualPassword)){
            System.out.println("Forget password verification Passed");
        }else {
            System.out.println("Forget password verification Failed");
        }
    }
}
