package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    //This method accepts an intiger which is for seconds and thread.sleep for the given duration.
    public static void sleep(int seconds){

        seconds*=1000;
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException e){

        }

    }

    //3. When this method is called, it should switch window and verify title.

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){
        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> windowHandles=driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);

            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
//            //5. Assert: Title contains “expectedTitle”
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //This method accepts a String "expectedTitle" and  asserts if it's true

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }


    //Creating a reusibility method so we don't have to repeat the lines
    public static void waitInvisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


}
