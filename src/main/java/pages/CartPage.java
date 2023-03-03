package pages;

import com.company.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td[class='product-name'] a")
    private WebElement productName;

    @FindBy(xpath = "//tr[@class='order-total']//bdi[1]")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    public boolean isRightProductInTheCart(String pName, double price) {
        String name = productName.getText().split("-")[0].trim();
        double priceP = Double.parseDouble(totalPrice.getText().split("₹")[1]);
        return name.equalsIgnoreCase(pName) && priceP == price;
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
}
