package com.krafttechexlab.tests;

import com.krafttechexlab.pages.AlertsPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class Practice09_Alerts extends TestBase{
    AlertsPage alertsPage = new AlertsPage();
    @Test
    public void test1_Alerts(){

        alertsPage.navigateToModule("JavaScript","Alerts");

        alertsPage.clickButton1.click();

        //create a alert object
        Alert alert = Driver.get().switchTo().alert();
        //accept alert by accept()
        alert.accept();
    }
    @Test
    public void test2_Alerts() throws InterruptedException {
        alertsPage.navigateToModule("JavaScript","Alerts");
        alertsPage.clickButton2.click();
        Thread.sleep(4000);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }
}
