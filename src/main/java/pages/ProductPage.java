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

    @FindBy(css = "div[role='alert']")
    private WebElement successMsg;

    public boolean productPageIsOpened(String productName) {
        return pageTitle.getText().equalsIgnoreCase(productName);
    }
    public void setColorAndSize(String color, String size) {
        Select s = new Select(chooseColor);
        s.selectByVisibleText(color);

        Select s1 = new Select(chooseSize);
        s1.selectByVisibleText(size);
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public void getSuccessMsg() {
        System.out.println(successMsg.getText());
        
    }












}
