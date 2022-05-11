package com.cydeo.homeworkTasks.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_NextBaseCRM {
    public static void main(String[] args) {
        //TC #1: NextBaseCRM, locators and getText() practice
       // 1- Open a chrome
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/
       driver.get("https://login1.nextbasecrm.com/");

       // 3- Enter incorrect username: “incorrect”
        WebElement userNameElement=driver.findElement(By.name("USER_LOGIN"));
        userNameElement.sendKeys("incorrect");

       // 4- Enter incorrect password: “incorrect”
        WebElement passwordElement=driver.findElement(By.name("USER_PASSWORD"));
        passwordElement.sendKeys("incorrect");

        //5- Click to login button.
        WebElement logInbuttonElement=driver.findElement(By.className("login-btn"));
        logInbuttonElement.click();

       // 6- Verify error message text is as expected:
        //Expected: Incorrect login or password

        WebElement errorMessage=driver.findElement(By.className("errortext"));
        String actualErrorMessage=errorMessage.getText();

        String expectedErrorMessage="Incorrect login or password";

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message TC Passed");
        }else {
            System.out.println("Error message TC failed");
        }

        driver.close();




       // PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
