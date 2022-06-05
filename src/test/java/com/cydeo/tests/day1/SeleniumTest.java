package com.cydeo.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //1-settin up the web driver manager
        WebDriverManager.chromedriver().setup();

        //2- Instance of the chrome driver
        WebDriver driver=new ChromeDriver();

        driver.get("https://google.com");

    }

}
