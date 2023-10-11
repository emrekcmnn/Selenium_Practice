package com.krafttechexlab.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.krafttechexlab.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Practice17_ExtentReportDemo {
    ExtentReports report;
    ExtentSparkReporter sparkReporter;
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        report= new ExtentReports();

        sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/test-output/report.html"));

        report.attachReporter(sparkReporter);

        sparkReporter.config().setReportName("Selenium Practice");

        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Tester","Emre");
    }
    @Test
    public void test(){
        extentLogger= report.createTest("Extent Report Demo");

        extentLogger.info("open browser");
        extentLogger.info("go to url ---> "+ConfigurationReader.get("url"));
   //     extentLogger.log(Status.INFO,ConfigurationReader.get("browser")+" browser has been launched successfully");
        extentLogger.pass("test is passed");
      //  extentLogger.log(Status.PASS,"test is passed");
    }

    @AfterMethod
    public void tearDown(){
        report.flush();
    }
}
