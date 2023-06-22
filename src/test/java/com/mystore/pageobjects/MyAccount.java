package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    //Create Object of webdriver
    WebDriver ldriver;

    //Constructor
    public MyAccount(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //Identify Webelements

    @FindBy(id="email_create")
    WebElement emailaddress;

    @FindBy(id="SubmitCreate")
    WebElement createaccbutton;


    @FindBy(id = "email")
    WebElement registeredEmailAddress;

    @FindBy(id ="passwd")
    WebElement registeredEmailPassword;

    @FindBy(id="SubmitLogin")
    WebElement signInButton;

    public void enterEmail(String emailid)
    {
        emailaddress.sendKeys(emailid);
    }

    public void clickcreateacc()
    {
        createaccbutton.click();
    }

    public void setRegisteredEmailAddress(String remailid) {
        registeredEmailAddress.sendKeys(remailid);
    }

    public void setRegisteredEmailPassword(String rpassword) {
        registeredEmailPassword.sendKeys(rpassword);
    }
    public void setSignInButton() {
        signInButton.click();
    }
}
