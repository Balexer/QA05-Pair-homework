package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class IvanSmokeTests extends BaseTest {
    String username = "standard_user";
    String password = "secret_sauce";


    @Test
//Будет ли ошибка если зайти заблокированным пользователем на странице Login
    public void smoke1() {
        String username = "locked_out_user";
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");
        loginPage.login(username, password);
        System.out.println(loginPage.getError());
    }

    @Test
//Будет ли ошибка если не вводить логин на странице Login
    public void smoke2() {
        String username = "";
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");
        loginPage.login(username, password);
        System.out.println(loginPage.getError());
    }

    @Test
//Будет ли ошибка если не вводить пароль на странице Login
    public void smoke3() {
        String password = "";
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");
        loginPage.login(username, password);
        System.out.println(loginPage.getError());
    }

    @Test
//Будет ли ошибка если не вводить логин и пароль на странице Login
    public void smoke4() {
        String username = "";
        String password = "";
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page was not opened.");
        loginPage.login(username, password);
        System.out.println(loginPage.getError());
    }
}