package com.mystore.testcases;

import com.mystore.pageobjects.CreationOfAccount;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccount;
import com.mystore.pageobjects.UserAccount;
import com.mystore.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestWithDataProvider extends BaseClass{

    @Test(enabled = false)
    public void verifyUserRegistration() throws InterruptedException {

        logger.info("<<<<<<<<<<<< verifyUserRegistration Test Execution Started >>>>>>>>>>>>>>>> ");

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("-----------Clicked on sign in link-------------");

        MyAccount myAccount = new MyAccount(driver);
        myAccount.enterEmail("vipil.chavan5@gmail.com");
        logger.info("-----------email id entered--------------");
        myAccount.clickcreateacc();
        logger.info("----------Clicked create account------------");
        Thread.sleep(2000);


        CreationOfAccount creationOfAccount = new CreationOfAccount(driver);

        creationOfAccount.setTitleMr();
        creationOfAccount.setFirstname("Vipil");
        creationOfAccount.setLastname("Chavan");
        creationOfAccount.setPassword("Vipil1929");
        creationOfAccount.setBirth_day(29);
        creationOfAccount.setBirth_month(5);
        creationOfAccount.setBirth_year(27);
        logger.info("-----------User account details entered-----------");
        creationOfAccount.setRegister();
        logger.info("-----------Clicked on register-----------");

        UserAccount userAccount = new UserAccount(driver);

        String username = userAccount.getUserAccName();
        logger.info("--------UserAccountName is-------- : "+username);

        Assert.assertEquals("Vipil Chavan",username,"<<<<< User Account Name Not Matched >>>>");



    }

    @Test(dataProvider = "LoginDetails")
    public void verifyLogin(String useremail,String userpass,String expectedusername) throws IOException {

        logger.info("<<<<<<<<<<<<< VerifyLogin Test Execution Started >>>>>>>>>>>>>");
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("-----------Clicked on sign in link-------------");

        MyAccount myAccount = new MyAccount(driver);

        myAccount.setRegisteredEmailAddress(useremail);


        logger.info("----------- registered email id entered--------------");
        myAccount.setRegisteredEmailPassword(userpass);
        logger.info("----------- registered email id passwd entered--------------");
        myAccount.setSignInButton();
        logger.info("----------- Clicked on signIn Button--------------");

        UserAccount userAccount = new UserAccount(driver);

        String username = userAccount.getUserAccName();
        logger.info("--------UserAccountName is-------- : "+username);

        if (username.equals(expectedusername))
        {
          logger.info("-------VerifyLogin----------::::::Passed");
          Assert.assertTrue(true);
        }
        else
        {
            logger.info("-------VerifyLogin----------::::::Failed");
            captureScreenShot(driver,"verifyLogin");
            Assert.fail();
        }

        userAccount.clickOnSignOut();
    }

    @DataProvider(name = "LoginDetails")
    public String[][] loginData() {
        String filename = System.getProperty("user.dir") + "\\TestData\\LoginDetails.xlsx";
        String sheetname = "UserDetails";

        int ttlrow = ReadExcelFile.getRowCount(filename, sheetname);
        int ttlcell = ReadExcelFile.getCellCount(filename, sheetname);

        String[][] data = new String[ttlrow - 1][ttlcell];

        for (int currentrow = 1; currentrow < ttlrow; currentrow++) {
            for (int currentcell = 0; currentcell < ttlcell; currentcell++) {

                data[currentrow - 1][currentcell] = ReadExcelFile.getCellValue(filename, sheetname, currentrow, currentcell);


            }

        }
        return data;

    }




}

