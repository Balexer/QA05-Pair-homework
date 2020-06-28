package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class IvanRegressionTests extends BaseTest {
    String username = "standard_user";
    String othusername = "standard_user";
    String password = "secret_sauce";

    @Test
    //Проверка кнопки "Cancel" на странице Overview
    public void regress1() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Wrong page");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Wrong page");
        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Ivan", "Varvaruk", "123456");

        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened());

        overviewPage.getBack();
        Assert.assertTrue(productsPage.isPageOpened(), "Wrong page");
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertTrue(overviewPage.isPageOpened());

    }

    @Test
    //Проверка верной стоимости товаров
    public void regress2() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Wrong page");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Wrong page");
        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Ivan", "Varvaruk", "123456");

        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened());

        overviewPage.getSubTotal();
        Assert.assertEquals(overviewPage.getSubTotal(), "Item total: $59.98", "Wrong Sub Total Price!");
        overviewPage.getTax();
        Assert.assertEquals(overviewPage.getTax(), "Tax: $4.80", "Wrong Tax Price!");
        overviewPage.getTotal();
        Assert.assertEquals(overviewPage.getTotal(), "Total: $64.78", "Wrong Total Price!");
        overviewPage.finishButton();

    }

    @Test
    //Проверка сообщения об успешном заказе при покупке на любую сумму
    public void regress3() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Wrong page");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Wrong page");
        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Ivan", "Varvaruk", "123456");

        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened());
        overviewPage.finishButton();

        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened());

        finishPage.getMessage();
        Assert.assertEquals(finishPage.getMessage(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                "Wrong message!");
    }

    @Test
    //Проверка сообщения об успешном заказе при сумме покупки в 0.00$
    public void regress4() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Wrong page");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Wrong page");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Wrong page");
        cartPage.moveInCheckout();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.fillInformation("Ivan", "Varvaruk", "123456");

        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened());

        overviewPage.getTotal();
        Assert.assertEquals(overviewPage.getTotal(), "Total: $0.00", "CART IS NOT EMPTY!!!");

        overviewPage.finishButton();

        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened());

        finishPage.getError();
        Assert.assertNotEquals(finishPage.getError(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                "Order accepted for zero amount!");
    }
}

