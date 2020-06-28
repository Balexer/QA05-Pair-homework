package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutStepOne;
import pages.LoginPage;
import pages.ProductsPage;

public class AlexSmokeTests extends BaseTest {

    String username = "standard_user";
    String password = "secret_sauce";


    @Test
    //проверим выпадет ли ошибка, если не ввести фамилию на странице CheckOutStepOne
    public void test1() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getDescription("Sauce Labs Fleece Jacket"), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "ti pidor");

        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Alex", "", "");
        System.out.println(checkoutStepOne.getError());

    }

    @Test
    //проверим выпадет ли ошибка, если не ввести имя на странице CheckOutStepOne
    public void test2() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page was not opened.");
        productsPage.addToCart("Sauce Labs Fleece Jacket");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("", "Bachurin", "423432");
        System.out.println(checkoutStepOne.getError());

    }

    @Test
    //проверим выпадет ли ошибка, если не ввести почтовый индекс на странице CheckOutStepOne
    public void test3() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page was not opened.");
        productsPage.addToCart("Sauce Labs Fleece Jacket");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Alex", "Bachurin", "");
        System.out.println(checkoutStepOne.getError());

    }
}
