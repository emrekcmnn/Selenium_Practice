package com.krafttechexlab.tests;

import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice11_Frames {
    WebDriver driver = Driver.get();
    @Test
    public void test1_nestedFrames(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String actualText = driver.findElement(By.id("content")).getText();
        String expectedText= "MIDDLE";

        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        actualText= driver.findElement(By.tagName("body")).getText();
        expectedText = "RIGHT";

        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().defaultContent(); //selenium switch to directly top

        driver.switchTo().frame(1);
        actualText= driver.findElement(By.tagName("body")).getText();
        expectedText = "BOTTOM";

        Assert.assertEquals(actualText,expectedText);

        Driver.closeDriver();

    }
}
