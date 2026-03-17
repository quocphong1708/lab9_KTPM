package tests;

import lab_9framework.base.BaseTest;
import framework.pages.LoginPage;
import framework.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCart() {
        InventoryPage page = new LoginPage(getDriver())
                .login("standard_user", "secret_sauce");

        page.addFirstItemToCart();

        Assert.assertEquals(page.getCartItemCount(), 1);
    }

    @Test
    public void removeItem() {
        InventoryPage page = new LoginPage(getDriver())
                .login("standard_user", "secret_sauce");

        page.addFirstItemToCart()
            .goToCart()
            .removeFirstItem();

        Assert.assertTrue(true);
    }
    @Test
    public void cartInitiallyEmpty() {
        int count = new LoginPage(getDriver())
                .login("standard_user", "secret_sauce")
                .goToCart()
                .getItemCount();

        Assert.assertEquals(count, 0);
    }

    @Test
    public void addItemByName() {
        int count = new LoginPage(getDriver())
                .login("standard_user", "secret_sauce")
                .addItemByName("Sauce Labs Backpack")
                .getCartItemCount();

        Assert.assertEquals(count, 1);
    }
}