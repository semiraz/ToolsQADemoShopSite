package pages;

import com.company.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".noo-search")
    private WebElement searchIcon;
    @FindBy(name = "s")
    private WebElement searchType;
    @FindBy(xpath = "//div[@id='slide-6-layer-9']")
    private WebElement shopNowLayer;
    @FindBy(xpath = "//a[normalize-space()='Dismiss']")
    private WebElement dismissLink;

    public void goToHomepage() {
        driver.get("https://shop.demoqa.com/");
        waitForWebElementToAppear(shopNowLayer);
        dismissLink.click();
    }

    public boolean verifyTitle(String title) {
        return driver.getTitle().contains(title);
    }

    public void enterSearchedWord(String searchedWord) {
        searchIcon.click();
        searchType.sendKeys(searchedWord, Keys.ENTER);
    }
}
