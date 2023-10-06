package com.krafttechexlab.tests;

import com.krafttechexlab.pages.RadioPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice02_RadioButton extends TestBase{


    RadioPage radioPage;
    /**
     * In this test, radio buttons were tested and
     * the disabled radio button could be clicked with the help of JavascriptExecutor.
     * */
    @Test
    public void test1_radioButtons(){
        radioPage =new RadioPage();
        radioPage.navigateToModule("Forms","Radio");

        Assert.assertTrue(radioPage.radioButton1.isSelected());
        Assert.assertFalse(radioPage.formCheck.isDisplayed());

        radioPage.radioButton2.click();
        Assert.assertTrue(radioPage.formCheck.isDisplayed());

        String expectedText="Radio 2";
        String actualText= radioPage.formCheck.getText();

        Assert.assertEquals(actualText,expectedText);

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].disabled= false",radioPage.disableRadioButton);
        js.executeScript("arguments[0].click();",radioPage.disableRadioButton);

        Assert.assertTrue(radioPage.disableRadioButton.isSelected());

    }
}
