package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioPage extends BasePage{

    @FindBy(id = "gridRadios1")
    public WebElement radioButton1;

    @FindBy(id = "gridRadios2")
    public WebElement radioButton2;

    @FindBy(id = "gridRadios")
    public WebElement disableRadioButton;

    @FindBy(id = "text")
    public WebElement formCheck;
}
