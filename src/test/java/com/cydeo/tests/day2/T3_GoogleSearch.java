package com.cydeo.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement googleSearchBox=driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Apple");
        googleSearchBox.click();

    }
}
