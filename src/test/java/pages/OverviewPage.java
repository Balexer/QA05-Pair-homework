package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
    private WebDriver driver;

    private By finishButtonSelector = By.cssSelector(".btn_action.cart_button");
    private By cancelButtonSelector = By.xpath("//a[@class='cart_cancel_link btn_secondary']");

    private String tmpIdentificator = "//div[text()='replace']/ancestor::div[@class='cart_item']";
    private String overNameIdentificator = tmpIdentificator + "/descendant::div[@class = 'inventory_item_name']";
    private String overPriceIdentificator = tmpIdentificator + "/descendant::div[@class = 'inventory_item_price']";

    private By checkText = By.xpath("//div[text()='Checkout: Overview']");
    private By SUBTOTALPRICE = By.className ("summary_subtotal_label");
    private By TAXPRICE = By.className ("summary_tax_label");
    private By TOTALPRICE = By.className("summary_total_label");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isPageOpened() {
        return driver.findElement(checkText).isDisplayed();
    }
    public void finishButton() {
        WebElement finishButton = driver.findElement(finishButtonSelector);
        finishButton.click();
    }
    public void getBack() {
        WebElement cancelButton = driver.findElement(cancelButtonSelector);
        cancelButton.click();
    }
    public String getPrice(String name) {
        String tmpOverPriceIdentificator = overPriceIdentificator.replace("replace", name);
        WebElement price = driver.findElement(By.xpath(tmpOverPriceIdentificator));

        return price.getText();
    }
    public String getName(String name) {
        String tmpOverItemNameIdentificator = overNameIdentificator.replace("replace", name);
        WebElement itemname = driver.findElement(By.xpath(tmpOverItemNameIdentificator));

        return itemname.getText();
    }
    public String getSubTotal() {
        WebElement total = driver.findElement(SUBTOTALPRICE);
        return total.getText();

    }
    public String getTax() {
        WebElement total = driver.findElement(TAXPRICE);
        return total.getText();

    }
    public String getTotal() {
        WebElement total = driver.findElement(TOTALPRICE);
        return total.getText();

    }
}
