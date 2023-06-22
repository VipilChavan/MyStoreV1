package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderPaymentPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div")
    WebElement payByCheck;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByWire;

    public void ClickOnPayByCheck() {
        payByCheck.click();
    }

    public void ClickOnPayByWire() {
        payByWire.click();
    }
}
