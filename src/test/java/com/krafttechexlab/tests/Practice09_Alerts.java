package com.krafttechexlab.tests;

import com.krafttechexlab.pages.AlertsPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class Practice09_Alerts extends TestBase{

    @Test
    public void test1_Alerts(){
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.navigateToModule("JavaScript","Alerts");

        alertsPage.clickButton1.click();

        //create a alert object
        Alert alert = Driver.get().switchTo().alert();
        //accept alert by accept()
        alert.accept();
    }
}
