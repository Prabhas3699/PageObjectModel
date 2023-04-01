package com.bridgelabz.page;

import com.bridgelabz.base.BassClass;
import com.bridgelabz.util.utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BassClass {

    LoginPage loginPage;

    HomePage homePage;

    @BeforeMethod
    public void setup(){
        launchBrowser();
        loginPage=new LoginPage();
    }

    @Test
    public void verifyLoginPageTitleTest(){
        String loginPageTitle = loginPage.verifyLoginPageTitle();
        Assert.assertEquals(loginPageTitle,"Facebook – log in or sign up");
    }

    @DataProvider
    public Object[][] getLoginTestData(){
        return utility.Testdata("login");
    }
    @Test(dataProvider = "getLoginTestData")
    public void loginTest(String username,String password){
        homePage=loginPage.Login(username,password);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
