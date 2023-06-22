package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreationOfAccount {

    WebDriver ldriver;

    public CreationOfAccount(WebDriver rdriver)
    {

        ldriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }
    //Web Elements of the page
    @FindBy(id = "id_gender1")
    WebElement titleMr;
    @FindBy(id = "customer_firstname")
    WebElement firstname;
    @FindBy(id = "customer_lastname")
    WebElement lastname;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "days")
    WebElement birth_day;
    @FindBy(id = "months")
    WebElement birth_month;
    @FindBy(id = "years")
    WebElement birth_year;
    @FindBy(id = "submitAccount")
    WebElement register;
    //Actions on webelements


    public void setTitleMr() {
        titleMr.click();
    }

    public void setFirstname(String fname)
    {
        firstname.sendKeys(fname);
    }

    public void setLastname(String lname){
        lastname.sendKeys(lname);
    }

    public void setPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void setBirth_day(int day)
    {
        Select select= new Select(birth_day);
        select.selectByIndex(day);
    }

    public void setBirth_month(int month)
    {
        Select select= new Select(birth_month);
        select.selectByIndex(month);
    }

    public void setBirth_year(int year)
    {
        Select select= new Select(birth_year);
        select.selectByIndex(year);
    }

    public void setRegister()
    {
        register.click();
    }



}
