package pages;

import com.company.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends PageObject {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".noo-product-item h3")
    private List<WebElement> productNames;

    public boolean verifyIfAllFilteredProductContainSearchedWord(String searchedWord) {
        String pName = "";
        for (WebElement name : productNames) {
            pName = name.getText();
        }
        return pName.contains(searchedWord);
    }

    public void clickOnProduct(String productName) {
        productNames.stream().filter(p -> p.getText().equalsIgnoreCase(productName))
                .findFirst().orElse(null).click();

    }











}
