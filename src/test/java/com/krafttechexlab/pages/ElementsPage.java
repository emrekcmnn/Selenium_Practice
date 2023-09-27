package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    @FindBy(name = "text")
    public WebElement textInputBox;

    @FindBy(name = "email")
    public WebElement emailInputBox;

    @FindBy(name = "password")
    public WebElement passwordInputBox;

    @FindBy(name = "number")
    public WebElement numberInputBox;

    @FindBy(id = "formFile")
    public WebElement fileUpload;

    @FindBy(name = "date")
    public WebElement dateInputBox;

    @FindBy(name = "time")
    public WebElement timeInputBox;

    @FindBy(id = "exampleColorInput")
    public WebElement colorPicker;

    @FindBy(name = "textarea")
    public WebElement textareaInputBox;


}
