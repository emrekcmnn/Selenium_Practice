package com.krafttechexlab.tests;

import com.krafttechexlab.pages.InputPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice01_Input extends TestBase{

    InputPage inputPage =new InputPage();

    //In this test, a simple form was filled ou. Additionally, it was verified that a disabled input box was disabled.
    //and text could be sent to this disable input box using JavascriptExecutor.
    @Test
    public void test1_input(){
      inputPage.navigateToModule("Forms","Input");
      Assert.assertFalse(inputPage.disableInputBox.isEnabled());
      inputPage.fillOutTheForm("I am here to practice Selenium", "Selenium/WebDriver123","456782356","The text sent to Disable Input Box");
    }
}
