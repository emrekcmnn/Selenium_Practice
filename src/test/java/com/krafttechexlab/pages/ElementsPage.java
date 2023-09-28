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

    @FindBy(id = "gridRadios1")
    public  WebElement radioButton1;

    @FindBy(id = "gridRadios2")
    public  WebElement radioButton2;

    @FindBy(id = "gridRadios")
    public  WebElement disabledRadioButton;

    @FindBy(id = "gridCheck1")
    public  WebElement checkBox1;

    @FindBy(id = "gridCheck2")
    public  WebElement checkBox2;

    @FindBy(id = "gridCheck3")
    public  WebElement disableCheckedCheckBox3;

    @FindBy(id = "gridCheck4")
    public  WebElement disableCheckBox4;

    @FindBy(name = "textDisabled")
    public WebElement disableText;

    @FindBy(name = "select")
    public WebElement selectMenu;

    @FindBy(name = "multiSelect")
    public WebElement multiSelectMenu;

    @FindBy(id = "flexSwitchCheckDefault")
    public  WebElement defaultSwitchCheckbox;

    @FindBy(id = "flexSwitchCheckChecked")
    public  WebElement checkedSwitchCheckbox;

    @FindBy(id = "flexSwitchCheckDisabled")
    public WebElement disabledSwitchCheckbox;

    @FindBy(id = "flexSwitchCheckCheckedDisabled")
    public  WebElement disabledCheckedSwitchCheckbox;

    @FindBy(id = "customRange1")
    public  WebElement customRange;

    @FindBy(id = "disabledRange")
    public  WebElement disabledRange;


    @FindBy(id = "floatingInput")
    public  WebElement floatingEmailBox;

    @FindBy(id = "floatingPassword")
    public  WebElement floatingPasswordBox;

    @FindBy(id = "floatingTextarea")
    public  WebElement floatingTextareaBox;

    @FindBy(name = "selectForm")
    public WebElement selectForm;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(className = "ozelpr")
    public WebElement form;

}
