package com.krafttechexlab.tests;

import com.krafttechexlab.pages.ElementsPage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Practice08_FillOutTheFullForm extends TestBase{

    /** JavascriptExecutor methods used are:
     *  js.executeScript("arguments[0].setAttribute('value','#edb879')",elementsPage.colorPicker); //pick color with JavascriptExecutor on the color picker
     *  js.executeScript("arguments[0].scrollIntoView(true)",elementsPage.textareaInputBox);      //sroll with JavascriptExecutor
     *  js.executeScript("arguments[0].setAttribute('checked','');",elementsPage.disabledRadioButton);
     *  js.executeScript("arguments[0].checked = false",elementsPage.disableCheckedCheckBox3);
     *  js.executeScript("arguments[0].checked = true",elementsPage.disableCheckBox4);
     *  */
    @Test
    public void test1_fillOutTheFormOnElementsPage() throws InterruptedException {
        ElementsPage elementsPage= new ElementsPage();

        elementsPage.navigateToModule("Forms","orm Elements");
        elementsPage.textInputBox.sendKeys("I am here!!!");
        elementsPage.emailInputBox.sendKeys("test@test.com");
        elementsPage.passwordInputBox.sendKeys("123456789");
        elementsPage.numberInputBox.sendKeys("987654321");

        Thread.sleep(500);

//File Upload

        String path="C:\\Users\\emrek\\IdeaProjects\\Selenium_Practice\\src\\test\\resources\\Xpath_CSS.txt";
        elementsPage.fileUpload.sendKeys(path);

//Date and Time

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String date1 =dateFormat.format(date);
      //  String date = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        elementsPage.dateInputBox.sendKeys(date1);
        System.out.println("date1 = " + date1);

        Thread.sleep(1000);

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hhssa"));
        elementsPage.timeInputBox.sendKeys(time+"pm");

        Thread.sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();

//Color Picker

        js.executeScript("arguments[0].setAttribute('value','#edb879')",elementsPage.colorPicker);              //pick color with JavascriptExecutor on the color picker
        Thread.sleep(500);

//Textarea

        elementsPage.textareaInputBox.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");

        js.executeScript("arguments[0].scrollIntoView(true)",elementsPage.textareaInputBox);                     //sroll with JavascriptExecutor
        Thread.sleep(500);

//Radios

        elementsPage.radioButton2.click();
        js.executeScript("arguments[0].setAttribute('checked','');",elementsPage.disabledRadioButton);

//Checkboxes

        elementsPage.checkBox1.click();
        Thread.sleep(500);
        elementsPage.checkBox2.click();

        js.executeScript("arguments[0].checked = false",elementsPage.disableCheckedCheckBox3);
        Thread.sleep(500);
        js.executeScript("arguments[0].checked = true",elementsPage.disableCheckBox4);

//Disabled text box

        js.executeScript("arguments[0].setAttribute('value'," +
                "'I can type on disable text area with JSExecuter');",elementsPage.disableText);

//Selects
        Select select = new Select(elementsPage.selectMenu);
        select.selectByVisibleText("One");

        Thread.sleep(500);
        select =new Select(elementsPage.multiSelectMenu);
        select.selectByIndex(2);
        Thread.sleep(500);

        //js.executeScript("window.scrollBy(0,550)"); // scroll down



//Switches

        elementsPage.defaultSwitchCheckbox.click();
        elementsPage.checkedSwitchCheckbox.click();
        Thread.sleep(500);

        js.executeScript("arguments[0].disabled = false",elementsPage.disabledSwitchCheckbox);
        elementsPage.disabledSwitchCheckbox.click();
        Thread.sleep(500);

        js.executeScript("arguments[0].disabled = false",elementsPage.disabledCheckedSwitchCheckbox);
        elementsPage.disabledCheckedSwitchCheckbox.click();

        Actions actions = new Actions(Driver.get());

        actions.scrollByAmount(0,550);      // scroll down

//Ranges

        actions.dragAndDropBy(elementsPage.customRange,300,0).perform();
        Thread.sleep(500);
        js.executeScript("arguments[0].setAttribute('min','8')",elementsPage.disabledRange);
        Thread.sleep(500);

//Floating labels

        actions.click(elementsPage.floatingEmailBox).sendKeys("test@test.com").perform();
        elementsPage.floatingPasswordBox.sendKeys("123456789"+ Keys.TAB+"I am here");

//Select

        select =new Select(elementsPage.selectForm);
        select.selectByValue("2");
        Thread.sleep(1000);
//Click Submit Button
        elementsPage.submitButton.click();
        Thread.sleep(4000);

      System.out.println("elementsPage.form.getText() = " + elementsPage.form.getText());
    }
}
