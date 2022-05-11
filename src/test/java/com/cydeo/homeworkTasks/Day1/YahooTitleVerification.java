package com.cydeo.homeworkTasks.Day1;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class YahooTitleVerification {
    public static void main(String[] args) {
        //TC #1: Yahoo Title Verification
        //1. Open Chrome browser
        //2. Go to https://www.yahoo.com
        //3. Verify title:
        //Expected: Yahoo
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://yahoo.com");
        String expectedTitle="Yahoo";
        String actualTitle= driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title test case Passed");
        }else {
            System.out.println("Title test case Failed");
        }
        driver.close();

    }
}
