package com.cydeo.homeworkTasks.day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_NextBaseCRM {
    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        WebElement rememberMeButton=driver.findElement(By.tagName("label"));
       String actualResultRememberMeLabelText= rememberMeButton.getText();

        //Expected: Remember me on this computer
        String expectedResultRememberMeLabelText="Remember me on this computer";
        if (actualResultRememberMeLabelText.equals(expectedResultRememberMeLabelText)){
            System.out.println("Remember me label text TC passed");
        }else {
            System.out.println("Remember me label text TC Failed");
        }
        System.out.println();


        //4- Verify “forgot password” link text is as expected:
       // Expected: Forgot your password?
        WebElement forgotPasswordText=driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordText=forgotPasswordText.getText();
        String expectedForgotPasswordText="Forgot your password?";
        if (actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Forget password text TC Passed");
        }else {
            System.out.println("Forget password text TC Failed");
        }

        System.out.println();
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        WebElement forgotPassword_hrefattribute=driver.findElement(By.cssSelector("a[class='login-link-forgot-pass']"));
        String actualHrefAttribute=forgotPassword_hrefattribute.getAttribute("href");

        String expectedHrefAttribute="forgot_password=yes";
        System.out.println("expectedHrefAttribute = " + expectedHrefAttribute);
        System.out.println("actualHrefAttribute = " + actualHrefAttribute);

        if (actualHrefAttribute.contains(expectedHrefAttribute)){
            System.out.println("Href attribute TC Passed");
        }else {
            System.out.println("Href attribute TC Failed");
        }

        driver.close();



        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
