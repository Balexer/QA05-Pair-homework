package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOne extends BasePage{


    private By FIRSTNAMESELECTOR = By.id("first-name");
    private By LASTNAMESELECTOR = By.id("last-name");
    private By POSTALCODESELECTOR = By.id("postal-code");
    private By CONTINUEBUTTONSELECTOR = By.className("cart_button");
    private By CHECKOUTPAGESELECTOR = By.className("subheader");
    private By ERRORSELECTOR = By.tagName("h3");

    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(CHECKOUTPAGESELECTOR).isDisplayed();
    }

    public void fillInformation(String firstName, String lastName, String postalcode) {
        driver.findElement(FIRSTNAMESELECTOR).sendKeys(firstName);
        driver.findElement(LASTNAMESELECTOR).sendKeys(lastName);
        driver.findElement(POSTALCODESELECTOR).sendKeys(postalcode);
        driver.findElement(CONTINUEBUTTONSELECTOR).click();

    }

    public String getError() {
        return driver.findElement(ERRORSELECTOR).getText();
    }
}
