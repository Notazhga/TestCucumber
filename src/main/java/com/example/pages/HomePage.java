package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = "a.login")
    private WebElement LogInLink;

    @FindBy(linkText = "nkamarskaya")
    private WebElement UserLink;

    @FindBy(css = "a.logout")
    private WebElement SignOutLink;

    @FindBy(linkText = "Projects")
    private WebElement Projects;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSigninLink() {
        LogInLink.click();
        return new LoginPage(driver);
    }

    public Boolean UserNameDisp() {
        return UserLink.isDisplayed();
    }

    public Boolean LogOutDisp() {
        return LogInLink.isDisplayed();
    }

    public void closeBrowser() {
        driver.quit();
    }
    public HomePage clickSignOut() {
        SignOutLink.click();
        return this;
    }


}