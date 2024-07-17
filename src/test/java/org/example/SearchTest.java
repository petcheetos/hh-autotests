package org.example;

import org.example.configuration.ConfigurationProperties;
import org.example.pages.SearchPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    public static SearchPage searchPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty("searchpage"));
    }

    @Test
    public void searchTest() {
        searchPage.inputKeyword("java");
        searchPage.search();
        CharSequence keyword = "java";
        assertTrue(searchPage.getKeyword().contains(keyword));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
