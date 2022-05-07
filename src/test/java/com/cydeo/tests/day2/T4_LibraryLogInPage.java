package com.cydeo.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryLogInPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://library2.cybertekschool.com/login.html");

        WebElement usernameInput=driver.findElement(By.className("form-control"));
        usernameInput.sendKeys("incorrect.cydeo@gmail.com");

        WebElement paswordInput=driver.findElement(By.id("inputPassword"));
        paswordInput.sendKeys("incorrect password");

        WebElement signInButton=driver.findElement(By.tagName("button"));
        signInButton.click();
    }
}
