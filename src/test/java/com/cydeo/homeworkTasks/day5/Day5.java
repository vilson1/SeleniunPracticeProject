package com.cydeo.homeworkTasks.day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Day5 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }

    @Test
    public void t1_staleElementReferenceException(){
//        Open Chrome browser
//        2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

//        3. Click to “Add Element” button
        WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

//        4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() ecpected True  = " + deleteButton.isDisplayed());

//        5. Click to “Delete” button.
        deleteButton.click();
//        6. Verify “Delete” button is NOT displayed after clicking.
        try {

            System.out.println("deleteButton.isDisplayed() expected False = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            e.getMessage();
        }

    }
    @Test
    public void t2_radioButtonHandaling(){
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement hockeyRadioButton=driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioButton.click();
//        4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyRadioButton.isSelected() expected True= " + hockeyRadioButton.isSelected());
    }

    @Test
   public void t4_SimpleDropdown(){
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”

        Select simpleDropDown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement selectedOption=simpleDropDown.getFirstSelectedOption();
        String actualSelectedOption= selectedOption.getText();

        String expectedSelectedOption="Please select an option";
        System.out.println("expectedSelectedOption = " + expectedSelectedOption);
        System.out.println("currentlySelectedOption = " + actualSelectedOption);
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);


//        4. Verify “State selection” default selected value is correct
//        Expected: “Select a State”simpleDropDown.getFirstSelectedOption();

        Select selectStateDropdown=new Select(driver.findElement(By.id("state")));
        WebElement defaultStateSelected=selectStateDropdown.getFirstSelectedOption();

        String actualDefaultStateSelected=defaultStateSelected.getText();
        String expectedDefaultStateSelected="Select a State";

        Assert.assertEquals(actualDefaultStateSelected,expectedDefaultStateSelected);
    }

    @Test
    public void t5_PracticeSelectingFromDropDown(){
//        1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select states=new Select(driver.findElement(By.xpath("//select[@id='state']")));
//        3. Select Illinois
        states.selectByValue("IL");
//        4. Select Virginia
        states.selectByVisibleText("Virginia");
//        5. Select California
        states.selectByIndex(5);
//        6. Verify final selected option is California.
        String actualSelectedState=states.getFirstSelectedOption().getText();
        String expectedSelectedState="California";

        Assert.assertEquals(actualSelectedState,expectedSelectedState);
//        Use all Select options. (visible text, value, index)
    }

    @Test

    public void t6_SelectingDateInDropDown() throws InterruptedException {
//        Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
//        3. Select “December 1st, 1923” and verify it is selected.
        Select year=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day=new Select(driver.findElement(By.xpath("//select[@id='day']")));

        year.selectByVisibleText("1923");
        month.selectByValue("11");
        day.selectByIndex(0);
//                Select year using  : visible text
//        Select month using   : value attribute
//        Select day using : index number
        Thread.sleep(5000);
    }

    @Test
    public void t7_NonSelectDropdown(){
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown ");

//        3. Click to non-select dropdown
        WebElement nonSelectDropdown=driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonSelectDropdown.click();
//        4. Select Facebook from dropdown
        WebElement facebookElement=driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebookElement.click();
//        5. Verify title is “Facebook - Log In or Sign Up”
        String actualFbTitle=driver.getTitle();
        String expectedFbTitle="Facebook - Log In or Sign Up";

        Assert.assertEquals(actualFbTitle.toLowerCase(),expectedFbTitle.toLowerCase());
    }

    @Test
    public void t8_SelectValueMultipleDropdown(){
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
//        3. Select all the options from multiple select dropdown.
        Select selectMultiple=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        selectMultiple.selectByIndex(0);
        selectMultiple.selectByIndex(1);
        selectMultiple.selectByIndex(2);
        selectMultiple.selectByIndex(3);
        selectMultiple.selectByIndex(4);
        selectMultiple.selectByIndex(5);
//        4. Print out all selected values.
        ArrayList<WebElement> selectedElements=new ArrayList<>(selectMultiple.getAllSelectedOptions());
        int i=1;
        for (WebElement selectedElement : selectedElements) {
            System.out.println("selected "+i+". Element = " + selectedElement.getText());
            i++;
        }

//        5. Deselect all values.
        selectMultiple.deselectAll();
    }
}
