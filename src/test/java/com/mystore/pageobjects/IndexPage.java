package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public IndexPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);

    }

    //Identify Webelements

    @FindBy(linkText = "Sign in")
    WebElement Signin;

    //Action On sign in

    public void clickOnSignIn()

    {
        Signin.click();
    }


}
