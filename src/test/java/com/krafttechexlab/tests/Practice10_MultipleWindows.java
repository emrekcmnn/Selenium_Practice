package com.krafttechexlab.tests;

import com.krafttechexlab.pages.OpenNewTabPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class Practice10_MultipleWindows extends TestBase{
    @Test
    public void test1_multipleWindows() throws InterruptedException {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage();
        openNewTabPage.navigateToModule("JavaScript","Open New Tab");

        String currentWindow = Driver.get().getWindowHandle();

        Thread.sleep(1000);
        openNewTabPage.openAlertsButton1.click();

        Set<String> windowHandles = Driver.get().getWindowHandles();
        Thread.sleep(1000);

        for (String windowHandle : windowHandles){
            if (!currentWindow.equals(windowHandle))
                Driver.get().switchTo().window(windowHandle);
        }
        Thread.sleep(1000);

        Driver.get().findElement(By.cssSelector("[class='btn-close']")).click();
        Thread.sleep(1000);
        Driver.get().close();
        Thread.sleep(1000);
        Driver.get().switchTo().window(currentWindow);
        Thread.sleep(1000);
        openNewTabPage.openAlertsButton2.click();
        windowHandles = Driver.get().getWindowHandles();
        for (String windowHandle : windowHandles){
            if (!currentWindow.equals(windowHandle))
                Driver.get().switchTo().window(windowHandle);
        }
        Driver.get().manage().window().maximize();
        Driver.get().findElement(By.cssSelector("[class='btn-close']")).click();
    }
}
