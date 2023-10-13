package com.krafttechexlab.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.krafttechexlab.utilities.ConfigurationReader;
import com.krafttechexlab.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected ExtentReports report;
    protected ExtentSparkReporter sparkReporter;
    protected ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if (result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String target = System.getProperty("user.dir")+"test-output/Screenshots/"+result.getName()+date+".png";
            File finalDestination = new File(target);
            //FileUtils.copyFile(source,finalDestination);
            FileHandler.copy(source,finalDestination);

            extentLogger.addScreenCaptureFromPath(target);
            extentLogger.fail(result.getThrowable());

        }
         Thread.sleep(2000);
         Driver.closeDriver();
    }
    @BeforeTest
    public void setUpTest(){
        report= new ExtentReports();

        sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/test-output/report.html"));

        report.attachReporter(sparkReporter);

        sparkReporter.config().setReportName("Selenium Practice");

        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Tester","Emre");
    }

    @BeforeTest
    public void tearDownTest(){
        report.flush();
    }
}
