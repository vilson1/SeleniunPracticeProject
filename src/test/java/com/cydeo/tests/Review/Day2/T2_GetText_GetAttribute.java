package com.cydeo.tests.Review.Day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_GetText_GetAttribute {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        WebElement rememberMeLabel=driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLabel="Remember me on this computer";
        String actualRememberMeLabel=rememberMeLabel.getText();

        if (expectedRememberMeLabel.equals(actualRememberMeLabel)){
            System.out.println("Verification Passed");
        }else {
            System.out.println("Verification Failed");
        }

        WebElement forgotPasswordLink=driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgetPasswordLink="Forgot Password Link";
        String actualForgetPasswordLink=forgotPasswordLink.getText();

        if (expectedForgetPasswordLink.equals(actualForgetPasswordLink)){
            System.out.println("Link verification passed");
        }else {
            System.out.println("Link verification failed");
        }

        String expectedInHref="forgot_password=yes";
        String actualInHref=forgotPasswordLink.getAttribute("href");

        System.out.println("actualInHref = " + actualInHref);
        System.out.println("ExpectedInHref = " + expectedInHref);

        if (actualForgetPasswordLink.contains(expectedInHref)){
            System.out.println("Href attribute value verification passed");
        }else {
            System.out.println("Href attribute value verification failed");
        }

    }
}
