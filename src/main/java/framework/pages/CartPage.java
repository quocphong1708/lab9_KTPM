package framework.pages;

import lab_9framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private By cartItems = By.className("cart_item");
    private By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
    private By checkoutBtn = By.id("checkout");
    private By itemNames = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemCount() {
        try {
            return driver.findElements(cartItems).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public CartPage removeFirstItem() {
        if (getItemCount() > 0) {
            waitAndClick(removeBtn);
        }
        return this;
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        driver.findElements(itemNames).forEach(e -> names.add(e.getText()));
        return names;
    }

    public CheckoutPage goToCheckout() {
        waitAndClick(checkoutBtn);
        return new CheckoutPage(driver);
    }
}