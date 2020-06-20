package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    private By CARTPAGESELECTOR = By.className("subheader");
    private By CHECKOUTBUTTONSELECTOR = By.className("checkout_button");
    private String ContinueShoppingButtonSelector = "//div[@class='cart_footer']/a[@class='btn_secondary']";
    private String itemNameIdentificator = "//div[text()='replace']";
    private String itemIdentificator = "//div[text()='replace']/ancestor::div[@class='cart_item_label']/descendant::";
    private String itemDescriptionIdentificator = itemIdentificator + "div[@class='inventory_item_desc']";
    private String itemPriceIdentificator = itemIdentificator + "div[@class='inventory_item_price']";
    private String itemRemoveIdentificator = itemIdentificator + "button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(CARTPAGESELECTOR).isDisplayed();
    }

    public boolean checkName(String name) {
        String itemName = itemNameIdentificator.replace("replace", name);
        return driver.findElement(By.xpath(itemName)).isDisplayed();
    }

    public String getDescription(String name) {
        String itemDescription = itemDescriptionIdentificator.replace("replace", name);
        WebElement description = driver.findElement(By.xpath(itemDescription));

        return description.getText();
    }


    public String getPrice(String name) {
        String itemPrice = itemPriceIdentificator.replace("replace", name);
        WebElement price = driver.findElement(By.xpath(itemPrice));

        return price.getText();
    }

    public void removeItem(String name) {
        String removeButton = itemRemoveIdentificator.replace("replace", name);
        WebElement remove = driver.findElement(By.xpath(removeButton));
        remove.click();
    }

    public void moveInCheckout () {
        driver.findElement(CHECKOUTBUTTONSELECTOR).click();
    }

    public void countinueShopping () {
        driver.findElement(By.xpath(ContinueShoppingButtonSelector)).click();
    }

}
