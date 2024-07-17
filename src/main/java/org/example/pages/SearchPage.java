package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public WebDriver driver;

    @FindBy(css = "[data-qa=\"search-input\"]")
    private WebElement searchField;

    @FindBy(css = "[data-qa=\"search-button\"]")
    private WebElement searchButton;

    @FindBy(css = "[data-qa=\"bloko-header-3\"]")
    private WebElement userKeyword;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputKeyword(String keyword) {
        searchField.sendKeys(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public String getKeyword() {
        return userKeyword.getText();
    }
}
