package tests;

import lab_9framework.base.BaseTest;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.login("standard_user", "secret_sauce").isLoaded());
    }

    @Test
    public void loginFail() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginExpectingFailure("wrong", "wrong");

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
    @Test
    public void loginWithEmptyUsername() {
        LoginPage page = new LoginPage(getDriver());
        page.loginExpectingFailure("", "secret_sauce");
        Assert.assertTrue(page.isErrorDisplayed());
    }

    @Test
    public void loginWithEmptyPassword() {
        LoginPage page = new LoginPage(getDriver());
        page.loginExpectingFailure("standard_user", "");
        Assert.assertTrue(page.isErrorDisplayed());
    }
    
}