package framework.pages;

import lab_9framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class InventoryPage extends BasePage {

    private By inventoryList = By.className("inventory_list");
    private By cartBadge = By.className("shopping_cart_badge");
    private By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isElementVisible(inventoryList);
    }

    public InventoryPage addFirstItemToCart() {
        waitAndClick(addToCartButtons);
        return this;
    }

    public InventoryPage addItemByName(String name) {
        By itemBtn = By.xpath("//div[text()='" + name + "']/ancestor::div[@class='inventory_item']//button");
        waitAndClick(itemBtn);
        return this;
    }

    public int getCartItemCount() {
        try {
            String text = getText(cartBadge);
            return Integer.parseInt(text);
        } catch (Exception e) {
            return 0;
        }
    }

    public CartPage goToCart() {
        waitAndClick(cartIcon);
        return new CartPage(driver);
    }
}