package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //Naviagte.to(url)

        driver.navigate().to("https://google.com");

        //Navigate.get(url)

        driver.get("\"https://google.com\"");

        //Navigate.back()
        driver.navigate().back();

        //NAvigate.fofrward()

        driver.navigate().forward();

        driver.navigate().refresh();
    }
}
