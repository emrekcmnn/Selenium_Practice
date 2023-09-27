package com.krafttechexlab.tests;

import com.krafttechexlab.pages.ElementsPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Practice08_FillOutTheFullForm extends TestBase{
    @Test
    public void test1_fillOutTheFormOnElementsPage() throws InterruptedException {
        ElementsPage elementsPage= new ElementsPage();

        elementsPage.navigateToModule("Forms","orm Elements");
        elementsPage.textInputBox.sendKeys("I am here!!!");
        elementsPage.emailInputBox.sendKeys("test@test.com");
        elementsPage.passwordInputBox.sendKeys("123456789");
        elementsPage.numberInputBox.sendKeys("987654321");

        Thread.sleep(500);

        String path="C:\\Users\\emrek\\IdeaProjects\\Selenium_Practice\\src\\test\\resources\\Xpath_CSS.txt";
        elementsPage.fileUpload.sendKeys(path);

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        elementsPage.dateInputBox.sendKeys(date);

        Thread.sleep(500);

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hhss"));
        elementsPage.timeInputBox.sendKeys(time);

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].setAttribute('value','#edb879')",elementsPage.colorPicker);

        Thread.sleep(1000);

        elementsPage.textareaInputBox.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");

    }
}
