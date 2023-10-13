package com.krafttechexlab.tests;

import com.krafttechexlab.pages.ElementsPage;
import com.krafttechexlab.utilities.ConfigurationReader;
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

public class Practice18_ExtentReportTest extends TestBase{
    @Test
    public void test1_fillOutTheFormOnElementsPageWithExtentReports() throws InterruptedException {
        extentLogger = report.createTest("Fill out The Full Form");
        extentLogger.info("went to website ---> "+ ConfigurationReader.get("url"));
        ElementsPage elementsPage= new ElementsPage();

        extentLogger.info("go to form page");
        elementsPage.navigateToModule("Forms","orm Elements");

        extentLogger.info("type input in text box");
        elementsPage.textInputBox.sendKeys("I am here!!!");

        extentLogger.info("type email in email box");
        elementsPage.emailInputBox.sendKeys("test@test.com");

        extentLogger.info("type password in password box");
        elementsPage.passwordInputBox.sendKeys("123456789");

        extentLogger.info("type number number box");
        elementsPage.numberInputBox.sendKeys("987654321");

       // Thread.sleep(500);

//File Upload
        extentLogger.info("upload a file");
        String path="C:\\Users\\emrek\\IdeaProjects\\Selenium_Practice\\src\\test\\resources\\Xpath_CSS.txt";
        elementsPage.fileUpload.sendKeys(path);

//Date and Time
        extentLogger.info("type date in date input box");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String date1 =dateFormat.format(date);

        elementsPage.dateInputBox.sendKeys(date1);


      //  Thread.sleep(1000);

        extentLogger.info("type time in time input box");
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hhssa"));
        elementsPage.timeInputBox.sendKeys(time+"pm");

     //   Thread.sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();

//Color Picker
        extentLogger.info("change color in color picker");
        js.executeScript("arguments[0].setAttribute('value','#edb879')",elementsPage.colorPicker);
     //   Thread.sleep(500);

//Textarea
        extentLogger.info("type text in textarea");
        elementsPage.textareaInputBox.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");

        js.executeScript("arguments[0].scrollIntoView(true)",elementsPage.textareaInputBox);

        Thread.sleep(500); //test is not executing without the wait

//Radios
        extentLogger.info("click the radio button");
        elementsPage.radioButton2.click();


//Checkboxes
        extentLogger.info("click the checkbox1");
        elementsPage.checkBox1.click();

        extentLogger.info("click the checkbox2");
        elementsPage.checkBox2.click();


//Selects
        extentLogger.info("select One");
        Select select = new Select(elementsPage.selectMenu);
        select.selectByVisibleText("One");

        extentLogger.info("select Two");
        select =new Select(elementsPage.multiSelectMenu);
        select.selectByIndex(2);



//Switches
        extentLogger.info("click the switches");
        elementsPage.defaultSwitchCheckbox.click();
        elementsPage.checkedSwitchCheckbox.click();
       // Thread.sleep(500);

        Actions actions = new Actions(Driver.get());

        actions.scrollByAmount(0,550);      // scroll down

//Range
        extentLogger.info("move to range");
        actions.dragAndDropBy(elementsPage.customRange,300,0).perform();

//Floating labels
        extentLogger.info("type email password and comments");
        actions.click(elementsPage.floatingEmailBox).sendKeys("test@test.com").perform();
        elementsPage.floatingPasswordBox.sendKeys("123456789"+ Keys.TAB+"I am here");

//Select
        extentLogger.info("select Two");
        select =new Select(elementsPage.selectForm);
        select.selectByValue("2");

//Click Submit Button
        extentLogger.info("Click Submit Button");
        elementsPage.submitButton.click();

        System.out.println("elementsPage.form.getText() = " + elementsPage.form.getText());

        extentLogger.pass("PASSED");
    }

}
