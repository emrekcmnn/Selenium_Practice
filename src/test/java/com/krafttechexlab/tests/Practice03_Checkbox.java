package com.krafttechexlab.tests;

import com.krafttechexlab.pages.CheckboxPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice03_Checkbox extends TestBase{

    CheckboxPage checkboxPage;

    /**
     * In this test, checkboxes were tested and
     * the disabled checkboxes could be clicked using 2 different JavascriptExecutor methods
     * */
    @Test
    public void test1_Checkboxes() throws InterruptedException {
        checkboxPage = new CheckboxPage();
        checkboxPage.navigateToModule("Forms","Checkbox");

        Assert.assertFalse(checkboxPage.checkbox1.isSelected());
        Assert.assertTrue(checkboxPage.checkedCheckbox2.isSelected());
        Assert.assertTrue(checkboxPage.disableCheckedCheckbox3.isSelected());
        Assert.assertFalse(checkboxPage.disableCheckbox4.isSelected());

        checkboxPage.checkbox1.click();
        Assert.assertTrue(checkboxPage.checkbox1.isSelected());
        Thread.sleep(500);
        checkboxPage.checkedCheckbox2.click();
        Assert.assertFalse(checkboxPage.checkedCheckbox2.isSelected());

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        Thread.sleep(500);

        //way 1
        js.executeScript("arguments[0].checked = false",checkboxPage.disableCheckedCheckbox3);
        Assert.assertFalse(checkboxPage.disableCheckedCheckbox3.isSelected());

        Thread.sleep(500);
        //way2
        js.executeScript("document.getElementById('gridCheck4').setAttribute('checked', '');");
        Assert.assertTrue(checkboxPage.disableCheckbox4.isSelected());
    }
}
