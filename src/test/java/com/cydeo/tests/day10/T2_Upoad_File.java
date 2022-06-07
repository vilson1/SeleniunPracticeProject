package com.cydeo.tests.day10;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upoad_File {
    @Test
    public void T2_uploadFile(){
//        1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
//        2. Find some small file from your computer, and get the path of it.
        String path="C:\\Users\\User\\Desktop\\photo.jpg";
        WebElement uploadElement=Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        uploadElement.sendKeys(path);
//        3. Upload the file.
        WebElement uploadButton=Driver.getDriver().findElement(By.xpath("//input[@class='button']"));
        uploadButton.click();
//        4. Assert:
        WebElement message=Driver.getDriver().findElement(By.xpath("//h3"));

        Assert.assertTrue(message.isDisplayed());
//        -File uploaded text is displayed on the page

    }
}
