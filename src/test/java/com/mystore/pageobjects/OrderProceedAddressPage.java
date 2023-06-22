package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProceedAddressPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderProceedAddressPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(name= "processAddress")
    WebElement proceedaddress;


    public void clickOnProceedCheckout() {
        proceedaddress.click();
    }



}
