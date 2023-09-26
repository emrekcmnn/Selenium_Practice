package com.krafttechexlab.tests;

import com.krafttechexlab.pages.RangesPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Practice07_Ranges extends TestBase{

    @Test
    public void test1_ranges() throws InterruptedException {
        RangesPage rangesPage = new RangesPage();
        rangesPage.navigateToModule("Forms","Ranges");

        Actions actions = new Actions(Driver.get());

        actions.dragAndDropBy(rangesPage.range, 200,0).perform();

        Thread.sleep(500);
        actions.dragAndDropBy(rangesPage.range, -700,0).perform();

        Thread.sleep(500);
        actions.clickAndHold(rangesPage.range).moveByOffset(400,0).perform();

        Thread.sleep(500);
        JavascriptExecutor js =(JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].setAttribute('min','5')",rangesPage.disableRange);

    }
}
