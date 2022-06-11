package com.cydeo.tests.day12;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_Practices  {
    LibraryLoginPage libraryLoginPage;
    @BeforeMethod
    private void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
         libraryLoginPage=new LibraryLoginPage();
    }
    @Test
    public void T1_required_field_error_message(){
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com

//        3- Do not enter any information
//        4- Click to “Sign in” button
        libraryLoginPage.signInButton.click();
//        5- Verify expected error is displayed:
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
//        Expected: This field is required.
        Driver.closeDriver();
    }

    @Test
    public void T2_invalid_email_format(){
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com

//        3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("vilson");
        libraryLoginPage.signInButton.click();

//        4- Verify expected error is displayed:
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
//        Expected: Please enter a valid email address.
        Driver.closeDriver();

    }

    @Test
    public void T3_library_negative_login(){
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com
//        3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.sendKeys("vilson@info.com");
        libraryLoginPage.inputPassword.sendKeys("useruser");
        libraryLoginPage.signInButton.click();
//        4- Verify title expected error is displayed:
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
//        Expected: Sorry, Wrong Email or Password
//
//        NOTE: FOLLOW POM DESIGN PATTERN
    }



}
