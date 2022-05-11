package com.cydeo.homeworkTasks.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC1_EtsyTitleVerification {
    public static void main(String[] args) {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        //2. Go to https://www.etsy.com
        //3. Search for “wooden spoon”
        //4. Verify title:
        //Expected: “Wooden spoon | Etsy”

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle=driver.getTitle();
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification test Passed");
        }else {
            System.out.println("Title verification test Failed");
        }
        driver.close();


    }
}
