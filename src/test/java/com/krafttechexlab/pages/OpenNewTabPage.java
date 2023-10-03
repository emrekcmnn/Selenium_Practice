package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPage extends BasePage{

    /**Click the button to open Alerts Page in new tab
     * */
    @FindBy(css = "[onclick='NewTab1()']")
    public WebElement openAlertsButton1;

    /**
     * Click the button to open an Alerts Page in a new browser window that is 700px wide and 400px tall.*/
    @FindBy(css = "[onclick='NewTab2()']")
    public WebElement openAlertsButton2;
}
