package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderShippingPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(id = "cgv")
    WebElement termOfServices;

    @FindBy(name = "processCarrier")
    WebElement checkout;

    public void clickOnTermOfServices() {
        termOfServices.click();
    }

    public void clickOnProceedCheckout() {
        checkout.click();
    }
}
