package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AlexRegressionTests extends BaseTest {
    String username = "standard_user";
    String password = "secret_sauce";

    @Test
    //проверим те ли товары добавляются в корзину, и соответствует ли у них цена
    public void test4() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page was not opened.");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Backpack");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page was not opened");
        Assert.assertTrue(cartPage.checkName("Sauce Labs Fleece Jacket"), "There is no such product");
        Assert.assertTrue(cartPage.checkName("Sauce Labs Backpack"), "There is no such product");
        Assert.assertEquals(cartPage.getPrice("Sauce Labs Fleece Jacket"), "49.99", "incorrect price");
        Assert.assertEquals(cartPage.getPrice("Sauce Labs Backpack"), "29.99", "incorrect price");

    }

    @Test
    //можно ли убрать товар из корзины
    public void test5() {

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page was not opened.");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Backpack");

        productsPage.moveInCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkName("Sauce Labs Backpack"), "Product not found");
        cartPage.removeItem("Sauce Labs Backpack");
        cartPage.countinueShopping();
        Assert.assertEquals(productsPage.nameOfButton("Sauce Labs Backpack"), "ADD TO CART", "Product not deleted");

    }

    @Test
    //Будет ли ошибка если зайти заблокированным пользователем на странице Login
    public void test6() {
        String username = "locked_out_user";
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");
        loginPage.login(username, password);
        System.out.println(loginPage.getError());
    }
}
