package com.krafttechexlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(name = "email")
    public WebElement emailInputBox;

    @FindBy(name = "password")
    public WebElement passwordInputBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    public void login(String email, String password){
        loginButtonOnBasePage.click();
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
