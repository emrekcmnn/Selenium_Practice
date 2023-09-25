package com.krafttechexlab.tests;

import com.krafttechexlab.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice05_FileUpload extends TestBase{
    FileUploadPage fileUploadPage = new FileUploadPage();
    @Test
    public void test1_fileUploadTest(){
        fileUploadPage.navigateToModule("Forms","File Upload");
        String projectPath= System.getProperty("user.dir");

        String filePath= projectPath+"/src/test/resources/Xpath_CSS.txt";
        fileUploadPage.chooseFile.sendKeys(filePath);
        fileUploadPage.submitFormButton.click();

        String fileName= "Xpath_CSS.txt";

        String expected = "Your file named \" "+fileName+ " \" has been sent.";
        String actual = fileUploadPage.fileUploadMessage.getText();

        Assert.assertEquals(actual,expected);

    }
}
