package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{
    @FindBy(id = "formFile")
    public WebElement chooseFile;

    @FindBy(css = "[type='submit']")
    public WebElement submitFormButton;

    @FindBy(css = "[role='alert']")
    public WebElement fileUploadMessage;
}
