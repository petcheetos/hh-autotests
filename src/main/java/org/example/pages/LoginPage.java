package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "[data-qa=\"login-input-username\"]")
    private WebElement loginField;

    @FindBy(css = "[data-qa=\"expand-login-by-password\"]")
    private WebElement loginWithPasswordButton;

    @FindBy(css = "[data-qa=\"login-input-password\"]")
    private WebElement passwordField;

    @FindBy(css = "[data-qa=\"account-login-submit\"]")
    private WebElement loginButton;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickLoginWithPasswordButton() {
        loginWithPasswordButton.click();
    }

    public void clickLoginButtonn() {
        loginButton.click();
    }
}
