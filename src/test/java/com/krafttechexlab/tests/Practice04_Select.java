package com.krafttechexlab.tests;

import com.krafttechexlab.pages.SelectPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Practice04_Select extends TestBase{

    SelectPage selectPage=new SelectPage();

    @Test
    public void test1_select(){
        selectPage.navigateToModule("Forms","Select");

        Select select = new Select(selectPage.dropDownMenu);

        List<WebElement> options = select.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }
}
