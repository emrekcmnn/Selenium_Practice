package com.krafttechexlab.tests;

import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Practice12_DataTables {
    WebDriver driver= Driver.get();

    @BeforeMethod
    public void setUp(){
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
      Driver.closeDriver();
    }
    @Test
    public void test1_printTable(){
        WebElement table1=driver.findElement(By.id("table1"));
        System.out.println("table1.getText() = \n" + table1.getText());
    }

    @Test
    public void test2_getAllHeaders(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header:headers){
            System.out.println(header.getText());
        }
    }

}
