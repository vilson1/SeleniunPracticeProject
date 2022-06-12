package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
    public DynamicControlsPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//div[.=' A checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//div[@id='loading']")

    public WebElement waitForItBar;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement itsGoneMessage;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    public WebElement enableButton;

    @FindBy(xpath = "//div[.='Wait for it... ']")
    public WebElement waitingBar;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement enambleMessage;


}
