package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import webcore.BrowserService;

@Listeners(AlexListener.class)

public class BaseTest {
    WebDriver driver;
    BrowserService browserService = new BrowserService();

    @BeforeMethod
    public void setUp() {
        driver = browserService.initBrowser();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
