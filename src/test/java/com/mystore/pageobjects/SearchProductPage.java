package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {


    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public SearchProductPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }


    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    WebElement productResult;

    @FindBy(linkText = "Sign out")
    WebElement signout;

    @FindBy(linkText = "More")
    WebElement more;

    public String getProductResult() {
        String product = productResult.getText();
        return product;
    }


    public void clickOnSignOut() {
        signout.click();

    }

    public void clickOnMore() {
        more.click();
    }
}
