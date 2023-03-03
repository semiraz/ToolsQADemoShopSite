package pages;

import com.company.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends PageObject {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-title")
    private WebElement pageTitle;
    @FindBy(id = "pa_color")
    private WebElement chooseColor;
    @FindBy(id = "pa_size")
    private WebElement chooseSize;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCartBtn;
    @FindBy(css = "div[class='woocommerce-variation-price'] bdi")
    private WebElement priceOfProduct;
    @FindBy(xpath = "//a[@title='View cart']//bdi[1]")
    private WebElement priceInCart;
    @FindBy(css = "div[role='alert']")
    private WebElement successMsg;
    @FindBy(css = "div[role='alert'] a")
    private WebElement viewCartBtn;

    public boolean productPageIsOpened(String productName) {
        return pageTitle.getText().equalsIgnoreCase(productName);
    }

    public void setColorAndSize(String color, String size) {
        Select s = new Select(chooseColor);
        s.selectByVisibleText(color);

        Select s1 = new Select(chooseSize);
        s1.selectByVisibleText(size);
    }

    public double getPriceOfProduct() {
        return Double.parseDouble(priceOfProduct.getText().split("₹")[1]);
    }

    public double getPriceInCart() {
        return Double.parseDouble(priceInCart.getText().split("₹")[1]);
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public boolean getSuccessMsg(String productName) {
        String productNameParsed = successMsg.getText().split("“")[1].split("”")[0];
        String p = "";
        if (productName.toLowerCase().equalsIgnoreCase(productNameParsed)) {
            p = productName.toLowerCase().concat("” has been added to your cart.");
        }
        return p.equalsIgnoreCase(productNameParsed.concat("” has been added to your cart."));
    }

    public void goToCart() {
        viewCartBtn.click();
    }
}