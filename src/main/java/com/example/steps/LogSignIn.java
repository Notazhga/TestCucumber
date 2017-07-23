package com.example.steps;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;


public class LogSignIn {
    private HomePage homePage;

    @When("go to base url")
    public void goToLoginPage() throws Exception {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        homePage = new HomePage(driver);
    }

    @When("^login with username (\\S+) and password (\\S+)$")
    public void loginWithNameAndPassword(String username, String password) {
        LoginPage loginPage = homePage.clickSigninLink();
        homePage = loginPage.login(username, password);
    }

    @Then("assert Logged in")
    public void assertLoggedIn() {
        assertTrue(homePage.UserNameDisp());
    }
    @Then("logout")
    public void logout() {
        homePage = homePage.clickSignOut();
        assertTrue(homePage.LogOutDisp());
        homePage.closeBrowser();
    }

}