package com.krafttechexlab.pages;

import com.krafttechexlab.utilities.Driver;
import netscape.javascript.JSException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPage extends BasePage{
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement textInputBox;

    @FindBy(css = "input[type='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "input[type='number']")
    public WebElement numberInputBox;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement disableInputBox;

    public void fillOutTheForm(String text, String password, String number, String text2){
        textInputBox.sendKeys(text);
        passwordInputBox.sendKeys(password);
        numberInputBox.sendKeys(number);

        JavascriptExecutor js= (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].setAttribute('value', '"+text2+"')",disableInputBox);

    }
}
