package com.cydeo.tests.day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        WebElement addElementButton=driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(2000);
        addElementButton.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() expected True = " + deleteButton.isDisplayed());
        Thread.sleep(2000);
        //5. Click to “Delete”
        deleteButton.click();
        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteButton.isDisplayed() expected False = " + deleteButton.isDisplayed());

        }catch (StaleElementReferenceException e){

            System.out.println("Element is deleted completely");
        }
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


    }
}
