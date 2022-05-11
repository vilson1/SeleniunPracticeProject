package com.cydeo.homeworkTasks.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC3_BackAndForthNavigation {
    public static void main(String[] args) {
       // TC #3: Back and forth navigation
       // 1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com ");

        //3- Click to Gmail from top right.

        WebElement gmailElement=driver.findElement(By.className("gb_d"));
        gmailElement.click();



        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitleOfGmail="Gmail";
        String actualTitleOfGmail=driver.getTitle();

        System.out.println("actualTitleOfGmail = " + actualTitleOfGmail);
        System.out.println("expectedTitle = " + expectedTitleOfGmail);

        if (actualTitleOfGmail.equals(expectedTitleOfGmail)){
            System.out.println("Gmail title test case Passed");
        }else {
            System.out.println("Gmail title test case Failed");
        }

        //5- Go back to Google by using the .back();

        driver.navigate().back();
        //6- Verify title equals:
        String expectedTitleOfGoogle="Google";
        String actualTitleOfGoogle=driver.getTitle();

        //Expected: Google

        if (actualTitleOfGoogle.equals(expectedTitleOfGoogle)){
            System.out.println("Google title test case Passed");
        }else {
            System.out.println("Google title test case Failed");
        }
        System.out.println("actualTitleOfGoogle = " + actualTitleOfGoogle);
        System.out.println("expectedTitleOfGoogle = " + expectedTitleOfGoogle);

        driver.close();
    }
}
