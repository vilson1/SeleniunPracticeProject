package com.cydeo.tests.Review.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");
        WebElement forgotPasswordLink=driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        WebElement emailBox=driver.findElement(By.name("email"));
        String expectedEmail="mikesmith@garbage.com";
        emailBox.sendKeys(expectedEmail);



        String actualEmail=emailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        if (actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("Email verification Passed");
        }
        else System.out.println("Email verification Failed");


    }
}
