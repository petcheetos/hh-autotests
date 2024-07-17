package org.example;

import org.example.configuration.ConfigurationProperties;
import org.example.pages.LoginPage;
import org.example.pages.PersonalPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static PersonalPage personalPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        personalPage = new PersonalPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.clickLoginWithPasswordButton();
        loginPage.inputLogin(ConfigurationProperties.getProperty("login"));
        loginPage.inputPasswd(ConfigurationProperties.getProperty("password"));
        loginPage.clickLoginButtonn();
        personalPage.showMenu();
        String user = personalPage.getUsername();
        Assert.assertEquals("Анастасия Денисовна Олейникова", user);
    }

    @AfterClass
    public static void tearDown() {
        personalPage.logout();
        driver.quit();
    }
}
