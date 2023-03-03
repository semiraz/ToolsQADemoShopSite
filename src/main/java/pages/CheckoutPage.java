package pages;

import com.company.PageObject;
import forms.BillingForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends PageObject {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;
    @FindBy(id = "billing_last_name")
    private WebElement lastName;
    @FindBy(id = "billing_company")
    private WebElement company;
    @FindBy(id = "billing_country")
    private WebElement country;
    @FindBy(id = "billing_address_1")
    private WebElement streetAddress;
    @FindBy(id = "billing_city")
    private WebElement city;
    @FindBy(id = "billing_state")
    private WebElement stateCanton;
    @FindBy(id = "billing_postcode")
    private WebElement pinCode;
    @FindBy(id = "billing_phone")
    private WebElement phone;
    @FindBy(id = "billing_email")
    private WebElement emailAddress;
    @FindBy(id = "createaccount")
    private WebElement createAnAccountCheckbox;
    @FindBy(id = "account_username")
    private WebElement username;
    @FindBy(id = "account_password")
    private WebElement password;
    @FindBy(xpath = "//input[@id='terms']")
    private WebElement termsCheckbox;
    @FindBy(id = "place_order")
    private WebElement submitBtn;

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    private WebElement orderReceivedMsg;
    @FindBy(css = "li[class='order'] strong")
    private WebElement orderNumber;
    @FindBy(xpath = "//address[1]")
    private WebElement billingAddressForm;

    public void fillBillingForm(BillingForm billingForm) {
        this.firstName.sendKeys(billingForm.getFirstName());
        this.lastName.sendKeys(billingForm.getLastName());
        Select s = new Select(country);
        s.selectByVisibleText(billingForm.getCountry());
        this.streetAddress.sendKeys(billingForm.getStreetAddress());
        this.pinCode.sendKeys(billingForm.getPinCode());
        this.city.sendKeys(billingForm.getCity());
        this.phone.sendKeys(billingForm.getPhone());
        this.emailAddress.sendKeys(billingForm.getEmailAddress());
    }

    public void checkAndCreateAnAccount(String username, String password) {
        createAnAccountCheckbox.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void checkTermsAndSubmitTheOrder() {
        Actions actions = new Actions(driver);
        actions.moveToElement(termsCheckbox).click().build().perform();
        submitBtn.click();
    }

    public boolean getOrderReceivedMsg() {
        waitForWebElementToAppear(orderReceivedMsg);
        return orderReceivedMsg.getText().contains("Thank you. Your order has been received.");
    }

    public int getOrderNumber() {
        return Integer.parseInt(orderNumber.getText());
    }

    public boolean isCorrectBillingInfoSaved(String customerName, String email, String address) {
        return billingAddressForm.getText().contains(customerName) && billingAddressForm.getText().contains(email)
                && billingAddressForm.getText().contains(address);
    }
}