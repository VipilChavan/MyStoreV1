package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.testcases.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListener implements ITestListener {

    ExtentSparkReporter  htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport()
    {
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String reportName = "MyStoreTestReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        //add system information/environment info to reports
        reports.setSystemInfo("Machine:", "testpc1");
        reports.setSystemInfo("OS", "windows 11");
        reports.setSystemInfo("browser:", readConfig.getBrowser());
        reports.setSystemInfo("user name:", "Vipil");

        //configuration to change look and feel of report
        htmlReporter.config().setDocumentTitle("Extent Listener Report");
        htmlReporter.config().setReportName("MystoreV1 Report");
        htmlReporter.config().setTheme(Theme.DARK);


    }





    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("ITest Listener:onStart executed : "+context.getName() );
    }

    public void onFinish(ITestContext context) {
        System.out.println("ITest Listener:onFinish executed : "+context.getName() );
        reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter
    }


    public void onTestStart(ITestResult result) {
        System.out.println("ITest Listener:onTestStart executed : "+result.getName() );
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("ITest Listener:onTestSuccess executed : "+result.getName() );
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + result.getName() ,ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("ITest Listener:onTestFailure executed : "+result.getName() );
        test = reports.createTest(result.getName());//create entry in html report
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() , ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+ "//screenshot//"+ result.getName()+ ".png";

        File screenShotFile = new File(screenShotPath);

        if (screenShotFile.exists())
        {
            test.fail("ScreenShot Of Failed TestCase Is Below" +test.addScreenCaptureFromPath(screenShotPath));
        }




    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("ITest Listener:onTestSkipped executed : "+result.getName() );
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + result.getName() ,ExtentColor.BROWN));
    }

}


