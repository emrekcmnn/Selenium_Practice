package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{

    @FindBy(id ="myBtnClick")
    public WebElement clickButton1;

    @FindBy(id="myBtnClick3s")
    public WebElement clickButton2;

    @FindBy(id = "myBtnClickC")
    public WebElement clickButton3;

    @FindBy(id="myBtnClickP")
    public WebElement clickButton4;

}
