package com.cydeo.tests.day13;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractice {
    DynamicControlsPage dynamicControlsPage;
    @BeforeMethod
    public void setUp(){
        dynamicControlsPage=new DynamicControlsPage();
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }
    @Test
    public void T2_explicit_wait_practice(){

//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/dynamic_controls
//        3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();
//        4- Wait until “loading bar disappears”
        /*Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        BrowserUtils.waitInvisibilityOf(dynamicControlsPage.waitForItBar);
//        5- Verify:
//        a. Checkbox is not displayed
        // Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.waitForItBar));
        try {

            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
//        b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());
//
//                NOTE: FOLLOW POM
    }

    @Test
    public void T3_T2_explicit_wait_practice2(){
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/dynamic_controls

//        3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();
//        4- Wait until “loading bar disappears”
        BrowserUtils.waitInvisibilityOf(dynamicControlsPage.waitingBar);
        Assert.assertTrue(!dynamicControlsPage.waitingBar.isDisplayed());
//        5- Verify:
//        a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isDisplayed());
//        b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.enambleMessage.isDisplayed());
//
//                NOTE: FOLLOW POM
    }
}
