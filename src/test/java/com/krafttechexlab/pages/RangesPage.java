package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RangesPage extends BasePage{
    @FindBy(id = "customRange1")
    public WebElement range;

    @FindBy(id = "disabledRange")
    public WebElement disableRange;
}
