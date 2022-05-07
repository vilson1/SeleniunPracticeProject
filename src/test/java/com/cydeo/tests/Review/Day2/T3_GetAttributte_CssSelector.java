package com.cydeo.tests.Review.Day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_GetAttributte_CssSelector {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        WebElement signInButton=driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedButtonText="Log In";

        String actualButtonText=signInButton.getAttribute("value");

        if (actualButtonText.equals(expectedButtonText)){
            System.out.println("Log in button text verification passed");
        }else {
            System.out.println("Log in button text verification Failed");
        }
        System.out.println("actualButtonText = " + actualButtonText);
        System.out.println("expectedButtonText = " + expectedButtonText);

    }
}
