package com.other.tests;

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
    @Test
    public void test3_printTableSize(){
        List<WebElement> allRowWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowWithHeader.size() = " + allRowWithHeader.size());

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        return allRowsWithoutHeader.size();
    }

    @Test
    public void test4_printAllCellsByIndex(){
        //We want to write a code that it will print all cells one by one
        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columnNumber; j++) {
                System.out.println(i + "/" + j + "-" + driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }
    }
    private String getSpecificCellBasedOnNumbersThatIsGiven(int row, int column){
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
    return element.getText();
    }
    @Test
    public void test5(){
        System.out.println(getSpecificCellBasedOnNumbersThatIsGiven(3, 5));
    }
}
