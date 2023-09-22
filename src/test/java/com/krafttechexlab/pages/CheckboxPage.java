package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends BasePage{
    @FindBy(id="gridCheck1")
    public WebElement checkbox1;

    @FindBy(id="gridCheck2")
    public WebElement checkedCheckbox2;

    @FindBy(id="gridCheck3")
    public WebElement disableCheckedCheckbox3;

    @FindBy(id="gridCheck4")
    public WebElement disableCheckbox4;
}
