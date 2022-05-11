package com.cydeo.homeworkTasks.day2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_BankHeaderVerification {
    public static void main(String[] args) {


      //  TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html ");

        //3. Verify header text
        WebElement headerText=driver.findElement(By.tagName("h3"));

        String actualHeaderText=headerText.getText();

        //Expected: “Log in to ZeroBank”
        String expectedHeaderText="Log in to ZeroBank";

        System.out.println("expectedHeaderText = " + expectedHeaderText);
        System.out.println("actualHeaderText = " + actualHeaderText);

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text test case Passed");
        }else {
            System.out.println("Header text test case Failed");
        }
        driver.close();


    }
}
