package com.mystore.testcases;

import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTest extends BaseClass {
    @Test(enabled = false)
    public void verifySearchProduct() throws IOException {

        String seachKey = "T-shirt";
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("-----------Clicked on sign in link-------------");

        MyAccount myAccount = new MyAccount(driver);

        myAccount.setRegisteredEmailAddress("vipilchavan@gmail.com");


        logger.info("----------- registered email id entered--------------");
        myAccount.setRegisteredEmailPassword("Vipil1929");
        logger.info("----------- registered email id passwd entered--------------");
        myAccount.setSignInButton();
        logger.info("----------- Clicked on signIn Button--------------");

        UserAccount userAccount = new UserAccount(driver);

        //Enter Details in SearchBox
        userAccount.setSearchBox("T-shirt");
        logger.info("-------------Details(T-shirt) entered in searchBox --------------");
        userAccount.clickOnSubmitSearch();
        logger.info("---------------Clicked SubmitSearch-----------------");


        SearchProductPage searchProductPage = new SearchProductPage(driver);

        String searchedProduct = searchProductPage.getProductResult();

        if (searchedProduct.contains(seachKey)) {
            logger.info("---------------verifySearchProduct Test :: Passed-----------------");

            Assert.assertTrue(true);


        } else {
            logger.info("---------------verifySearchProduct Test :: Failed-----------------");
            captureScreenShot(driver, "verifySearchProduct");

            Assert.fail();

        }


    }


   @Test(enabled = true)
    public void verifyBuyProduct() throws IOException, InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("-----------Clicked on sign in link-------------");

        MyAccount myAccount = new MyAccount(driver);

        myAccount.setRegisteredEmailAddress(userEmail);



        logger.info("----------- registered email id entered--------------");
        myAccount.setRegisteredEmailPassword(pass);

        logger.info("----------- registered email id passwd entered--------------");
        myAccount.setSignInButton();
        logger.info("----------- Clicked on signIn Button--------------");

        UserAccount userAccount = new UserAccount(driver);

        //Enter Details in SearchBox
        userAccount.setSearchBox("T-shirt");
        logger.info("-------------Details(T-shirt) entered in searchBox --------------");
        userAccount.clickOnSubmitSearch();
        logger.info("---------------Clicked SubmitSearch-----------------");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.clickOnMore();
        logger.info("--------------Clicked on more button---------------");

        OrderBuyingTshirtPage orderBuyingTshirtPage= new OrderBuyingTshirtPage(driver);
        orderBuyingTshirtPage.getBlueT_shirt();
        logger.info("---------------Clicked bule colour-----------------");
        orderBuyingTshirtPage.setQuantityWanted("2");
        logger.info("---------------Quantity 2 Set-----------------");

        orderBuyingTshirtPage.setSize("M");
        logger.info("---------------Size M set-----------------");
        orderBuyingTshirtPage.clickAddToCart();
        logger.info("---------------Clicked add to cart-----------------");
        orderBuyingTshirtPage.clickOnProceedCheckout();
        logger.info("---------------Clicked ProceedCheckout-----------------");

        OrderCartSummaryPage orderSumPg = new OrderCartSummaryPage(driver);
        orderSumPg.clickOnProceedCheckout();
        logger.info("---------------Clicked on proceed to checkout on order summary page--------------");

        OrderProceedAddressPage orderAddPg = new OrderProceedAddressPage(driver);
        orderAddPg.clickOnProceedCheckout();
        logger.info("-----------Clicked on proceed to checkout on order address page---------------");


        OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
        orderShippingPg.clickOnTermOfServices();
        logger.info("-----------Checked term of service check box--------------");

        orderShippingPg.clickOnProceedCheckout();
        logger.info("------------Clicked on proceed to checkout on order shipping page-------------");

        OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);


        orderPaymentPg.ClickOnPayByCheck();
        logger.info("--------------Clicked on pay by cheque------------");

       OrderIConfirmMyOrderPage orderConfirmPg = new OrderIConfirmMyOrderPage(driver);
        orderConfirmPg.ClickConfirmOrder();



        logger.info("------------Clicked on confirmed order------------");

        String sucessMsg = orderConfirmPg.getSucessAlert();

        //	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

        if(sucessMsg.equals("Your order on My Store is complete."))
        {
            logger.info("***************"+sucessMsg+"*********************");
            logger.info("<<<<<<<<<<<<<<<<<<<<VerifyBuyProduct Test Case - Passed>>>>>>>>>>>>>>>>");
            Assert.assertTrue(true);

            orderConfirmPg.ClickOnSignOut();

        }
        else
        {
            logger.info("<<<<<<<<<<<<<<<<<<<<VerifyBuyProduct Test Case - Failed>>>>>>>>>>>>>>>>");
            captureScreenShot(driver,"VerifyBuyProduct");
            Assert.assertTrue(false);

        }

        logger.info("***************TestCase BuyProduct Ends *****************");



    }


}
