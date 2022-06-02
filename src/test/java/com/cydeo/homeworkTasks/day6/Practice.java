package com.cydeo.homeworkTasks.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test

    public void T1_Information_Alert_Practice() {
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
//        3. Click to “Click for JS Alert” button
        WebElement JSelement = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        JSelement.click();
//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.
        WebElement messageElement = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));
        String actualresult = messageElement.getText();
        Assert.assertEquals(actualresult, "You successfully clicked an alert");
    }

    @Test
    public void T2_Information_Alert_Practice() {
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts ");
//        3. Click to “Click for JS Confirm” button
        WebElement conformJS = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        conformJS.click();
//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement displayedText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = displayedText.getText();
        String expectedResult = "You clicked: Ok";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test

    public void T3_Information_Alert_Practice() {
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts ");
//        3. Click to “Click for JS Prompt” button

        WebElement promptJS = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptJS.click();
//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
//        5. Click to OK button from the alert
        alert.accept();
//        6. Verify “You entered:  hello” text is displayed.
        WebElement textMessage = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String actualResult = textMessage.getText();
        String expectedResult = "You entered: hello";
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(actualResult, expectedResult);


    }

    @Test
    public void T4_IframePractice() {
//        1. Create a new class called: T4_Iframes
//        2. Create new test and make set ups
//        3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe ");

//        4. Assert: “Your content goes here.” Text is displayed.
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(text.getText().equals("Your content goes here."));


//        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        WebElement titleWebElement = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(titleWebElement.isDisplayed());
    }

    @Test
    public void T5_windowsHandlePractice(){
//        1. Create a new class called: T5_WindowsPractice
//        2. Create new test and make set ups
//        3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
//        4. Assert: Title is “Windows”
        Assert.assertTrue(driver.getTitle().equals("Windows"));
//        5. Click to: “Click Here” link
        WebElement clickButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
//        6. Switch to new Window.

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);

        }


//        7. Assert: Title is “New Window”
        Assert.assertTrue(driver.getTitle().equals("New Window"));


    }



}
