package com.krafttechexlab.pages;

import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//li[contains(@class,'dropdown')]")
    public List<WebElement> menuList;
    @FindBy(css = ".d-none.d-md-block.dropdown-toggle.ps-2")
    public WebElement userAccountName;
    @FindBy(xpath = "//span[.='Developers']")
    public WebElement developersMenu;
    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboardMenu;
    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginButtonOnBasePage;

    public void navigateToModule(String tab){
        Driver.get().findElement(By.xpath("//span[.='" + tab + "']")).click();
    }


    public void navigateToModule(String tab, String module) {
        String tabLoc = "//span[text()='" + tab + "']";
        String moduleLoc = "//span[text()='" + module + "']";
        Driver.get().findElement(By.xpath(tabLoc)).click();
          try {
                Driver.get().findElement(By.xpath(moduleLoc)).click();
          }catch (ElementNotInteractableException e){
                moduleLoc= "("+moduleLoc+")[2]";
                Driver.get().findElement(By.xpath(moduleLoc)).click();
          }
    }

    public String getAccountName(String accountName){
        return Driver.get().findElement(By.xpath("//span[.='"+accountName+"']")).getText();
    }
}
