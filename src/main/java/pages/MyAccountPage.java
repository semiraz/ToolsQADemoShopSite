package pages;

import com.company.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Orders']")
    private WebElement ordersLink;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;

    public OrdersPage goToOrders() {
        waitForWebElementToAppear(ordersLink);
        ordersLink.click();
        return new OrdersPage(driver);
    }

    public void logout() {
        logoutLink.click();
    }
}
