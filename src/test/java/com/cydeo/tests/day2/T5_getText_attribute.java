package com.cydeo.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_attribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");

        WebElement headerText=driver.findElement(By.tagName("h2"));

        String expected="Registration form";
        String actual=headerText.getText();

        if (actual.equals(expected)){
            System.out.println("Header text verification Passed");
        }
        else   System.out.println("Header text verification Failed");

        WebElement firstName=driver.findElement(By.name("firstname"));
        String expectedPlaceHolder="first name";

        String actualPlaceHolder=firstName.getAttribute("placeholder");

        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder verification Passed");
        }
        else System.out.println("Placeholder verification Failed");

    }
}
