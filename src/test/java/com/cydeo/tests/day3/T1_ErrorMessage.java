package com.cydeo.tests.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_ErrorMessage {
    public static void main(String[] args) {
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        WebElement inputUserName=driver.findElement(By.name("USER_LOGIN"));
        inputUserName.sendKeys("incorrect");

        WebElement inputPassword=driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        WebElement loginButton= driver.findElement(By.className("login-btn"));
        loginButton.click();

        WebElement errorMessage=driver.findElement(By.className("errortext"));

        String expectedMessage="Incorrect login or password";
        String actualMessage=errorMessage.getText();
        if (actualMessage.equals(expectedMessage)){
            System.out.println("Error message Passed");
        }
        else System.out.println("Error message Failed");





    }
}
