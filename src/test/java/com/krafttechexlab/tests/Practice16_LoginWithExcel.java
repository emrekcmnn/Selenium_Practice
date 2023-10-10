package com.krafttechexlab.tests;

import com.krafttechexlab.pages.LoginPage;
import com.krafttechexlab.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Practice16_LoginWithExcel extends TestBase {

   /*
    @Test
    public void readExcelFile(){
        ExcelUtils userData = new ExcelUtils("src/test/resources/loginData.xlsx","Sayfa1");
        System.out.println("userData.rowCount() = " + userData.rowCount());
        System.out.println("userData.columnCount() = " + userData.columnCount());
        System.out.println("userData.getCellData(2,1) = " + userData.getCellData(2, 1));
        System.out.println("userData.getColumnsNames() = " + userData.getColumnsNames());

        List<Map<String, String>> dataList = userData.getDataList();

        for (Map<String,String> oneRow : dataList){
            System.out.println("oneRow = " + oneRow);
        }

        System.out.println("dataList.get(2) = " + dataList.get(2));
        System.out.println("dataList.get(4).get(\"Name\") = " + dataList.get(4).get("name"));

        String[][] dataArray= userData.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));
    }
    */


    @DataProvider
    public Object[][] userData(){
        ExcelUtils userData = new ExcelUtils("src/test/resources/loginData.xlsx","Sayfa1");
        return userData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void test1_loginWithExcelData(String email,String password,String name) throws InterruptedException {
        LoginPage loginPage= new LoginPage();
        loginPage.login(email, password);
        //Thread.sleep(1000);
        Assert.assertEquals(loginPage.getAccountName(name),name);
    }
}
