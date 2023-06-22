package com.mystore.testcases;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
     public static WebDriver driver;

    ReadConfig readConfig = new ReadConfig();

    public static Logger logger;

    String url = readConfig.getBaseUrl();
    String browser= readConfig.getBrowser();

    String userEmail= readConfig.getUseremail();

    String pass=readConfig.getPassword();

    @BeforeClass
    public void setup() {


        //launch browser

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("msedge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            driver = null;
        }
        if (driver != null) {
            driver.manage().window().maximize();
        }
        //Implicitly Wiat
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        // logger
        logger= LogManager.getLogger(BaseClass.class);
        logger.info("-----------Browser Opened-----------"+browser);

        driver.get(url);
        logger.info("---------URL opened----------");


    }

    @AfterClass
    public void tearDown()
    {


        logger.info("----------Closing Browser------------");
        driver.close();
        driver.quit();
        logger.info("----------Browser Closed-------------");
    }

    public void captureScreenShot(WebDriver driver ,String testName) throws IOException
    {
        //covert webdriver to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot)driver);


        //getScreenshotAs method creates imagefile and return type is file so store in the FIle Object
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        //Crate a destation to  store the captured screenshot

        File dest = new File(System.getProperty("user.dir") + "//screenshot//" + testName + ".png");

        //Copy the file to the destation
        FileUtils.copyFile(src,dest);



    }


}


