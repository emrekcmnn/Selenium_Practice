package com.other.tests;

import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Practice14_StaleElement {
   WebDriver driver;

    @Test
    public void staleFix(){
        driver= Driver.get();
        driver.get("https://freecrm.com/");
        driver.manage().window().maximize();

        WebElement loginBtn = driver.findElement(By.xpath("//span[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");


        driver.navigate().refresh();
  //      emailInput.sendKeys("email@gmail.com");           //stale element

        try {
            emailInput.sendKeys("email@gmail.com");
        }
        catch (StaleElementReferenceException e){
            emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("email@gmail.com");
            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("123456");
        }

        Driver.closeDriver();
    }
}
