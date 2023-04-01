package com.bridgelabz.page;

import com.bridgelabz.base.BassClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SavedPageTest extends BassClass {
    LoginPage loginPage;

    HomePage homePage;

    SavedPage savedPage;



    @BeforeMethod
    public void setup(){
        launchBrowser();
        loginPage=new LoginPage();
        homePage=loginPage.Login("8109555221","Test12345");
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Facebook");
    }

    @Test
    public void goToSavedpageTest(){
         savedPage=homePage.goToSavedPage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
