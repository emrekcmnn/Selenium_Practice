package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchesPage extends BasePage{

    @FindBy(id = "flexSwitchCheckDefault")
    public WebElement defaultSwitchCheckbox;

    @FindBy(id = "flexSwitchCheckChecked")
    public WebElement checkedSwitchCheckbox;

    @FindBy(id="flexSwitchCheckDisabled")
    public WebElement disableSwitchCheckbox;

    @FindBy(id="flexSwitchCheckCheckedDisabled")
    public WebElement disableCheckedSwitchCheckbox;

}
