package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://cydeo.com");

        String title= driver.getTitle();
        System.out.println("The title of the page is: "+title);

        if (title.equals("Cydeo"))
            System.out.println("passed");
        else
            System.out.println("failed");

        driver.close();
    }
}
