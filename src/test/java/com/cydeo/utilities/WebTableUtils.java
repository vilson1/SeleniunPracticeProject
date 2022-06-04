package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {
//    This method should accept a costumerName and return the costumer order date as a String.
    //    • Name: returnOrderDate ()
    //    • Return type: String
    //    • Arg1: WebDriver driver
    //    • Arg2: String costumerName

    public static String returnOrderDate(WebDriver driver, String costumerName){

        String locator="//td[.='"+costumerName+"']/following-sibling::td[3]";
        WebElement costumerDateCell=driver.findElement(By.xpath(locator));
        return costumerDateCell.getText();

    }

//    • Name: orderVerify ()
//    • Return type: void
//    • Arg1: WebDriver driver
//    • Arg2: String costumerName
//    • Arg3: String expectedOrderDate
//    This method should accept above mentioned arguments and internally assert
//    expectedOrderDate matching actualOrderDate.


    public static void orderVerify(WebDriver driver,String costumerName, String expectedOrderDate){

        String locator="//td[.='"+costumerName+"']/following-sibling::td[3]";
        WebElement costumerDateCell=driver.findElement(By.xpath(locator));

        String actualOrderDate=costumerDateCell.getText();
        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }

}
