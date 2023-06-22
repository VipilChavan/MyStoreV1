package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderBuyingTshirtPage {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public OrderBuyingTshirtPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }


    @FindBy(id="color_14")
    WebElement blueT_shirt;

    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(id = "group_1")
    WebElement sizeWanted;
    @FindBy(name="Submit")
    WebElement addToCart;

    @FindBy(linkText = "Proceed to checkout")
    WebElement checkout;

    public void getBlueT_shirt() {
        blueT_shirt.click();
    }

    public void setQuantityWanted(String quantity) {
        quantityWanted.clear();
        quantityWanted.sendKeys(quantity);
    }


    public void setSize(String size) {
        Select selectSize= new Select(sizeWanted);
        selectSize.selectByVisibleText(size);
    }


    public void clickAddToCart() {
               addToCart.click();
    }

    public void clickOnProceedCheckout()
    {
        checkout.click();
    }

}
