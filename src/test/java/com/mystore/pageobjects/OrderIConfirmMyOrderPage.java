package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderIConfirmMyOrderPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderIConfirmMyOrderPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
    WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]")
    WebElement sucessAlert;

    @FindBy(linkText = "Sign out")
    WebElement signOut;


    public String getSucessAlert() {

       String text= sucessAlert.getText();
        return text;

    }

    public void ClickOnSignOut() {
        signOut.click();

    }

    public void ClickConfirmOrder() {
        confirmOrder.click();
    }
}
