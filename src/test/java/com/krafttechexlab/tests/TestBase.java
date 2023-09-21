package com.krafttechexlab.tests;

import com.krafttechexlab.utilities.ConfigurationReader;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;



public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
         Thread.sleep(2000);
         Driver.closeDriver();
    }

}
