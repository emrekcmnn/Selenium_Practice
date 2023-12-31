package com.krafttechexlab.tests;

import com.krafttechexlab.pages.SelectPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Practice04_Select extends TestBase{

    SelectPage selectPage;

    @Test
    public void test1_select(){
        selectPage=new SelectPage();
        selectPage.navigateToModule("Forms","Select");

        Select select = new Select(selectPage.dropDownMenu);

        List<WebElement> options = select.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }
    @Test
    public void test2_selectByVisibleText(){
        selectPage=new SelectPage();
        selectPage.navigateToModule("Forms","Select");

        Select select = new Select(selectPage.dropDownMenu);

        //select two web element by visible text
        select.selectByVisibleText("Two");

        WebElement firstSelectedOption = select.getFirstSelectedOption();

        String expected = "Two";
        String actual =firstSelectedOption.getText();

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test3_selectByIndexNumber(){
        selectPage=new SelectPage();
        selectPage.navigateToModule("Forms","Select");

        Select select = new Select(selectPage.dropDownMenu);

        select.selectByIndex(1);
        String actual = select.getFirstSelectedOption().getText();
        String expected = "One";

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test_selectByValueAttribute(){
        selectPage=new SelectPage();
        selectPage.navigateToModule("Forms","Select");

        Select select = new Select(selectPage.dropDownMenu);

        select.selectByValue("3");
        String actual = select.getFirstSelectedOption().getText();
        String expected = "Three";

        Assert.assertEquals(actual,expected);

    }
}
