package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends BasePage{

    @FindBy(id = "draggable")
    public WebElement draggableElement;
}
