package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccount {

    WebDriver ldriver;

    //Constructor
    public UserAccount(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement userAccName;


    @FindBy(linkText = "Sign out")
    WebElement signout;

    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(name = "submit_search")
    WebElement submitsearch;


    //Action on webelements


    public void setSearchBox(String search) {
        searchBox.sendKeys(search);
    }

    public String getUserAccName() {
        String name = userAccName.getText();
        return name;
    }

    public void clickOnSignOut() {
        signout.click();

    }

    public void clickOnSubmitSearch()
    {
        submitsearch.click();
    }

}
