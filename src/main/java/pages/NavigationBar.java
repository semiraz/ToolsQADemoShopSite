package pages;

import com.company.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends PageObject {
    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='My Wishlist']")
    private WebElement myWishlistLink;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    private WebElement checkoutLink;

    public MyAccountPage goToMyAccountPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)", "", "");
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).click().build().perform();
        return new MyAccountPage(driver);
    }
}