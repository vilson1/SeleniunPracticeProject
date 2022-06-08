package com.cydeo.tests.day10;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions {
    @Test
    public void T1_hoveringTest(){
//        1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
//        2. Hover over to first image
        WebElement img1=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2=Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3=Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();

//        3. Assert:
//        a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());
//        b. “view profile” is displayed

        WebElement viewProfile1=Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[1]"));
        WebElement viewProfile2=Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[2]"));
        WebElement viewProfile3=Driver.getDriver().findElement(By.xpath("(//a[text()='View profile'])[3]"));
        Assert.assertTrue(viewProfile1.isDisplayed());

//        4. Hover over to second image
        actions.moveToElement(img2).perform();
//        5. Assert:
        Assert.assertTrue(user2.isDisplayed());
        Assert.assertTrue(viewProfile2.isDisplayed());
//        a. “name: user2” is displayed
//        b. “view profile” is displayed


//        6. Hover over to third image
        actions.moveToElement(img3).perform();
//        7. Confirm:
        Assert.assertTrue(user3.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());
//        a. “name: user3” is displayed
//        b. “view profile” is displayed
    }
}
