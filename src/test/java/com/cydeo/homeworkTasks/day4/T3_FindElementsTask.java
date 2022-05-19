package com.cydeo.homeworkTasks.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_FindElementsTask {
    public static void main(String[] args) {
//        1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

//        3- Locate all the links in the page.
        List<WebElement> links=driver.findElements(By.tagName("a"));

//        4- Print out the number of the links on the page.
        System.out.println("links.size() = " + links.size());
//        5- Print out the texts of the links.
        for (WebElement link : links) {
            System.out.println("link.getText() = " + link.getText());

        }
//        6- Print out the HREF attribute values of the links
        for (WebElement link : links) {
            link.getAttribute("href");
        }
    }
}
