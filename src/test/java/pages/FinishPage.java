package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {
    private WebDriver driver;

    private By finishText = By.xpath("//div[@class='pony_express']");
    private By RESULT = By.className("complete-text");

    public boolean isPageOpened() {
        return driver.findElement(finishText).isDisplayed();
    }

    public FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        WebElement total = driver.findElement(RESULT);
        return total.getText();
    }
    public String getError() {
        WebElement total = driver.findElement(RESULT);
        return total.getText();
    }
}