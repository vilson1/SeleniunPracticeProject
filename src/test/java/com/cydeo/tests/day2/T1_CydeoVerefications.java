package com.cydeo.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerefications {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();


        driver.navigate().to("https://practice.cydeo.com");

        String expectedUrl="cydeo";

        String actual=driver.getCurrentUrl();

        if (expectedUrl.equals(actual)){
            System.out.println("URL verification passed");
        }
        else
            System.out.println("URL verification failed");


        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification passed");
        }
        else
            System.out.println("Title verification failed");



        driver.close();

    }

}
