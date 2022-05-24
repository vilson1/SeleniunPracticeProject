package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    //This method will log in with helpdesk1@cyberteckschool.com when it's called
    public static void CRM_Login(WebDriver driver){
       // 3. Enter valid username
        WebElement usernameElement=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameElement.sendKeys("helpdesk1@cybertekschool.com");
//        4. Enter valid password
        WebElement passwordElement=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordElement.sendKeys("UserUser");
//        5. Click to `Log In` button
        WebElement logInButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

    }
    public static void CRM_Login(WebDriver driver,String username, String password){
        // 3. Enter valid username
        WebElement usernameElement=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameElement.sendKeys(username);
//        4. Enter valid password
        WebElement passwordElement=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordElement.sendKeys(password);
//        5. Click to `Log In` button
        WebElement logInButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();
    }
}
