package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutStepOne;
import pages.LoginPage;
import pages.ProductsPage;
import webcore.BrowserService;

public class AlexDependTest {
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
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

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
    //проверим соответствует ли описание товара "Sauce Labs Fleece Jacket"
    public void cart() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getDescription("Sauce Labs Fleece Jacket"), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "ti pidor");

        cartPage.moveInCheckout();
    }

    @Test(dependsOnMethods={"cart"}, priority = 4)
    //проверим будет ли ошибка если заполнить только имя
    public void checkout() {
        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Alex", "", "");
        System.out.println(checkoutStepOne.getError());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
