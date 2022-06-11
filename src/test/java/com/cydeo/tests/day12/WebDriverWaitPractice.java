package com.cydeo.tests.day12;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {
    @Test
    public void T4_dynamicLoadPractice1(){
//        1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
//        2. Wait until title is “Dynamic title”
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
//        3. Assert:
//        Message “Done” is displayed.
        DynamicLoad7Page dynamicLoad7Page=new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
//        4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
//                Note: Follow POM

    }

    @Test
    public void T5_dynamicLoadPractice2(){

        DynamicLoad1Page dynamicLoad1Page=new DynamicLoad1Page();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
//        1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

//        2. Click to start
        dynamicLoad1Page.startButton.click();
//        3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));
//        4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());
//        5. Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");
//        6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");
//        7. Click to Submit button
        dynamicLoad1Page.submitButton.click();
//        8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
//                Note: Follow POM Design Pattern
    }
}
