package pages;

import com.company.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends PageObject {
    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number a")
    private WebElement orderNumber;

    public boolean isSameOrderNumber(int orderNo) {
        int parsedOrderNo = Integer.parseInt(orderNumber.getText().split("#")[1].trim());
        return parsedOrderNo == orderNo;
    }
}
