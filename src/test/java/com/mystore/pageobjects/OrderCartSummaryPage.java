package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCartSummaryPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderCartSummaryPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(linkText = "Proceed to checkout")
   WebElement checkout;


    public void clickOnProceedCheckout() {
        checkout.click();
    }
}
