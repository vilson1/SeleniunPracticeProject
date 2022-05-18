package com.cydeo.tests.day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton2 {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        // 3. Click to “Hockey” radio button
        //4. Verify “Hockey” radio button is selected after clicking.

        clickAndVerifyRadioButton(driver,"sport","hockey");

    }

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValua){

        List<WebElement> radioButtons=driver.findElements(By.name(nameAttribute));

        for (WebElement radioButton : radioButtons) {
            String eachId= radioButton.getAttribute("id");
            if (eachId.equals(idValua)){
                radioButton.click();
                System.out.println("radioButton.isSelected() expected True = " + radioButton.isSelected());
                break;
            }

        }
    }
}
