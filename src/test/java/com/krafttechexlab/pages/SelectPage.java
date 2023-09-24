package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPage extends BasePage{

    @FindBy(xpath = "(//select[@class='form-select'])[1]")
    public WebElement dropDownMenu;

    @FindBy(xpath = "(//select[@class='form-select'])[2]")
    public WebElement selectMenu;
}
