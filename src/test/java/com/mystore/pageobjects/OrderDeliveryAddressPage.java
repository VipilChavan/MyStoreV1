package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderDeliveryAddressPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderDeliveryAddressPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(id="address1")
    WebElement address;
    @FindBy(id="city")
    WebElement city;
    @FindBy(id="id_state")
    WebElement state;
    @FindBy(id="postcode")
    WebElement zipcode;
    @FindBy(id="id_country")
    WebElement country;

    @FindBy(id="phone_mobile")
    WebElement mobNo;
    @FindBy(id="alias")
    WebElement addressTitle;

    @FindBy(id="submitAddress")
    WebElement submitaddress;

    public void setAddress(String useraddress) {
        address.sendKeys(useraddress);
    }

    public void setCity(String usercity) {
       city.sendKeys(usercity);
    }

    public void setState(String userstate) {
        Select selectState = new Select(state);

        selectState.selectByVisibleText(userstate);
    }

    public void setCountry(String usercountry) {
        country.sendKeys(usercountry);
    }

    public void setZipcode(String userzipcode) {
        zipcode.sendKeys(userzipcode);
    }

    public void setMobNo(String usermobNo) {
        mobNo.sendKeys(usermobNo);
    }

    public void setAddressTitle(String useraddressTitle) {
       addressTitle.sendKeys(useraddressTitle);
    }

    public void clickSaveAddress() {
       submitaddress.click();
    }
}
