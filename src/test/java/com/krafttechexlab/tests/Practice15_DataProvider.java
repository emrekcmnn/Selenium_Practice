package com.krafttechexlab.tests;

import com.krafttechexlab.pages.AlertsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice15_DataProvider extends TestBase {

    @DataProvider
    public Object[][] test(){
        String[][] menuList={
                {"Components","Alerts"},
                {"Components","Accordion"},
                {"Components","Carousel"},
                {"Components","List Group"},
                {"Components","Modal"},
                {"Components","Tabs"},
                {"Components","Tooltips"},
                {"Components","Charts"},
        };
        return menuList;
    }

    @Test(dataProvider = "test")
    public void test1_dataProvider(String tab, String module ){
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.navigateToModule(tab,module);
    }
}
