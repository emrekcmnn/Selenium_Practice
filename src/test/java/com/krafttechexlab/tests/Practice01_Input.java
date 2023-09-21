package com.krafttechexlab.tests;

import com.krafttechexlab.pages.HomePage;
import org.testng.annotations.Test;

public class Practice01_Input extends TestBase{
    HomePage homePage = new HomePage();
    @Test
    public void test1_input(){
      homePage.navigateToModule("Forms","Input");
    }
}
