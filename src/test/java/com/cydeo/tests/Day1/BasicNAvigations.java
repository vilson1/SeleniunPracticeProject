package com.cydeo.tests.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNAvigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tesla.com");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().refresh();

        driver.navigate().to("https://google.com");

        System.out.println(driver.getTitle());

        String currentURL;
        currentURL=driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //driver.close();

        driver.navigate().to("https://yahoo.com");
        String title=driver.getTitle();
        System.out.println(title);
        if (title.contains("Yahoo")){
            System.out.println(true);
        }
        else System.out.println(false);

    }
}
