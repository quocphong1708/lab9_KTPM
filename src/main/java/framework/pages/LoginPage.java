package framework.pages;

import lab_9framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage login(String user, String pass) {
        waitAndType(username, user);
        waitAndType(password, pass);
        waitAndClick(loginBtn);
        return new InventoryPage(driver);
    }

    public LoginPage loginExpectingFailure(String user, String pass) {
        waitAndType(username, user);
        waitAndType(password, pass);
        waitAndClick(loginBtn);
        return this;
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }

    public boolean isErrorDisplayed() {
        return isElementVisible(errorMsg);
    }
}