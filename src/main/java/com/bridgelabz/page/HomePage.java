package com.bridgelabz.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.base.BassClass.driver;

public class HomePage {

    @FindBy(xpath="//span[contains(text(),'John Smith')]")
    private WebElement profile;

    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    private WebElement saved;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }



    public ProfilePage goToProfile(){
        profile.click();
        return new ProfilePage();
    }

    public SavedPage goToSavedPage(){
        saved.click();
        return new SavedPage();
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }
}
