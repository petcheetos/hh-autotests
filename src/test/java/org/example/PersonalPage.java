package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PersonalPage {
    public WebDriver driver;

    public PersonalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[data-qa=\"mainmenu_applicantProfile\"]")
    private WebElement avatarButton;

    @FindBy(css = "[data-qa=\"mainmenu_logoffUser\"]")
    private WebElement logout;
    @FindBy(css = "[data-qa=\"mainmenu_applicantInfo\"]")
    private WebElement username;

    public void showMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa=\"mainmenu_applicantProfile\"]")));
        avatarButton.click();
    }

    public String getUsername() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return username.getText();
    }

    public void logout() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        logout.click();
    }
}
