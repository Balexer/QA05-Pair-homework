package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import webcore.BrowserService;

public class IvanDependTest {
    String username = "standard_user";
    String password = "secret_sauce";
    WebDriver driver;
    BrowserService browserService = new BrowserService();

    @BeforeTest
    public void setUp() {
        driver = browserService.initBrowser();
    }

    @Test(priority = 1)
    //Залогинимся и проверим на той ли мы странице
    public void login() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Wrong page");

        loginPage.login(username, password);
    }

    @Test(dependsOnMethods={"login"}, priority = 2)
    //добавим 2 товара в корзину
    public void products() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.moveInCart();
    }

    @Test(dependsOnMethods={"products"}, priority = 3)
    //Проверка открытия страницы CartPage
    public void cart() {
            CartPage cartPage = new CartPage(driver);
            Assert.assertTrue(cartPage.isPageOpened(), "Wrong page");
            cartPage.moveInCheckout();
    }

    @Test(dependsOnMethods={"cart"}, priority = 4)
    //Заполняем данные на странице CheckoutStepOne
    public void checkoutfill() {
            CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
            checkoutStepOne.fillInformation("Ivan", "Varvaruk", "123456");

    }

    @Test(dependsOnMethods = {"checkoutfill"}, priority = 5)
    public void overviewcheck() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened());
        overviewPage.getBack();
    }

    @Test(dependsOnMethods = {"overviewcheck"}, priority = 6)
    public void cancelbutton() {
        ProductsPage productsPage = new ProductsPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Wrong page");
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertTrue(overviewPage.isPageOpened());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
