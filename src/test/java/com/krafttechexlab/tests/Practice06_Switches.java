package com.krafttechexlab.tests;

import com.krafttechexlab.pages.SwitchesPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice06_Switches extends TestBase {

    SwitchesPage switchesPage= new SwitchesPage();

    @Test
    public void test1_Switches() throws InterruptedException {
        switchesPage.navigateToModule("Forms","Switches");

        Thread.sleep(500);
        switchesPage.defaultSwitchCheckbox.click();
        Assert.assertTrue(switchesPage.defaultSwitchCheckbox.isSelected());

        Thread.sleep(500);
        switchesPage.checkedSwitchCheckbox.click();
        Assert.assertFalse(switchesPage.checkedSwitchCheckbox.isSelected());

        Thread.sleep(500);
        Assert.assertFalse(switchesPage.disableSwitchCheckbox.isEnabled());
        Assert.assertFalse(switchesPage.disableCheckedSwitchCheckbox.isEnabled());

        JavascriptExecutor js= (JavascriptExecutor) Driver.get();

        Thread.sleep(500);
        js.executeScript("arguments[0].checked = true",switchesPage.disableSwitchCheckbox);
        Assert.assertTrue(switchesPage.disableSwitchCheckbox.isSelected());

        Thread.sleep(500);
        js.executeScript("arguments[0].checked = false",switchesPage.disableCheckedSwitchCheckbox);
        Assert.assertFalse(switchesPage.disableCheckedSwitchCheckbox.isSelected());


    }
}
