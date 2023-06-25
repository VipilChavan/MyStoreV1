package com.mystore.testcases;

import com.mystore.pageobjects.CreationOfAccount;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccount;
import com.mystore.pageobjects.UserAccount;
import org.apache.commons.collections4.functors.TruePredicate;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseClass{
//
//    @Test(enabled = true)
//    public void verifyUserRegistration() throws InterruptedException, IOException {
//
//        logger.info("<<<<<<<<<<<< verifyUserRegistration Test Execution Started >>>>>>>>>>>>>>>> ");
//
//        IndexPage indexPage = new IndexPage(driver);
//        indexPage.clickOnSignIn();
//        logger.info("-----------Clicked on sign in link-------------");
//
//        MyAccount myAccount = new MyAccount(driver);
//        myAccount.enterEmail("vipil.chavan26@gmail.com");
//        logger.info("-----------email id entered--------------");
//        myAccount.clickcreateacc();
//        logger.info("----------Clicked create account------------");
//        Thread.sleep(2000);
//
//
//        CreationOfAccount creationOfAccount = new CreationOfAccount(driver);
//
//        creationOfAccount.setTitleMr();
//        creationOfAccount.setFirstname("Vipil");
//        creationOfAccount.setLastname("Chavan");
//        creationOfAccount.setPassword("Vipil1929");
//        creationOfAccount.setBirth_day(29);
//        creationOfAccount.setBirth_month(5);
//        creationOfAccount.setBirth_year(27);
//        logger.info("-----------User account details entered-----------");
//        creationOfAccount.setRegister();
//        logger.info("-----------Clicked on register-----------");
//
//        UserAccount userAccount = new UserAccount(driver);
//
//        String username = userAccount.getUserAccName();
//        logger.info("--------UserAccountName is-------- : "+username);
//
//        Assert.assertEquals("Vipil Chavan",username,"<<<<< User Account Name Not Matched >>>>");
//
//
//
//    }

    @Test(enabled = true)
    public void verifyLogin() throws IOException {

        logger.info("<<<<<<<<<<<<< VerifyLogin Test Execution Started >>>>>>>>>>>>>");
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("-----------Clicked on sign in link-------------");

        MyAccount myAccount = new MyAccount(driver);

        myAccount.setRegisteredEmailAddress("vipil.chavan19@gmail.com");


        logger.info("----------- registered email id entered--------------");
        myAccount.setRegisteredEmailPassword("Vipil1929");
        logger.info("----------- registered email id passwd entered--------------");
        myAccount.setSignInButton();
        logger.info("----------- Clicked on signIn Button--------------");

        UserAccount userAccount = new UserAccount(driver);

        String username = userAccount.getUserAccName();
        logger.info("--------UserAccountName is-------- : "+username);

        if (username.equals("Vipil Chavan"))
        {
          logger.info("-------VerifyLogin----------::::::Passed");
          Assert.assertTrue(true);
        }
        else
        {
            logger.info("-------VerifyLogin----------::::::Failed");
            captureScreenShot(driver,"verifyLogin");
            Assert.assertTrue(false);
        }

    }






}

