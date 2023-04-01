package com.bridgelabz.page;

import com.bridgelabz.base.BassClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BassClass {

    @FindBy(id="email")
    private WebElement username;

    @FindBy(name = "pass")
    private WebElement password;

    @FindBy(name="temp login")
    private WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage Login(String uname,String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }

    public String verifyLoginPageTitle(){
        return driver.getTitle();
    }
}
