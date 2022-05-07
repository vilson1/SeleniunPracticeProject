package com.cydeo.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTestPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        //driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink=driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        String expectedTitle="No A/B Test";

        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification Passed");
        }
        else System.out.println("Title verification Failed");

        driver.navigate().back();

        expectedTitle="Practice";
        actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification Passed");
        }
        else System.out.println("Title verification Failed");



    }
}
