package tests.smoke_test;

import forms.BillingForm;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import test_components.BaseTest;

import java.io.IOException;

import static test_components.Utilities.*;

public class E2ETest extends BaseTest {

    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected SearchPage searchPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected BillingForm billingForm;
    protected NavigationBar navigationBar;
    protected MyAccountPage myAccountPage;
    protected OrdersPage ordersPage;

    @BeforeTest
    public void setUp() throws IOException {
        driver = initializeDriver();

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        navigationBar = new NavigationBar(driver);
    }

    @Test(testName = "Smoke Test")
    public void smokeTest() throws InterruptedException {
        homePage.goToHomepage();
        softAssert.assertTrue(homePage.verifyTitle(title), pageLoadFail("Homepage"));

        homePage.enterSearchedWord(searchedWord);
        softAssert.assertTrue(homePage.verifyTitle(searchedWord));

        softAssert.assertTrue(searchPage.verifyIfAllFilteredProductContainSearchedWord(searchedWord), errorFilterMsg);
        searchPage.clickOnProduct(productName);
        Thread.sleep(2000);

        softAssert.assertTrue(productPage.productPageIsOpened(productName), pageLoadFail("ProductPage"));
        productPage.setColorAndSize(color, size);
        Thread.sleep(2000);
        double price = productPage.getPriceOfProduct();
        productPage.addToCart();

        softAssert.assertEquals(price, productPage.getPriceInCart());
        softAssert.assertTrue(productPage.getSuccessMsg(productName), errorAddToCartMsg);
        productPage.goToCart();

        softAssert.assertTrue(homePage.verifyTitle("Cart"), pageLoadFail("CartPage"));
        softAssert.assertTrue(cartPage.isRightProductInTheCart(productName, price), errorAddToCartMsg);
        cartPage.proceedToCheckout();

        softAssert.assertTrue(homePage.verifyTitle("Checkout"), pageLoadFail("CheckoutPage"));

        String fName = generateFirstName();
        String lName = generateLastName();
        String email = generateRandomEmail(3, fName, lName);
        billingForm = new BillingForm.BillingFormBuilder().setFirstName(fName).setLastName(lName)
                .setCountry(country).setStreetAddress(street).setPinCode("71000")
                .setCity(city).setPhone(getRandomNumbers(10)).setEmailAddress(email).build();
        checkoutPage.fillBillingForm(billingForm);
        checkoutPage.checkAndCreateAnAccount(email, generateRandomPassword());
        Thread.sleep(2000);
        checkoutPage.checkTermsAndSubmitTheOrder();

        softAssert.assertTrue(checkoutPage.getOrderReceivedMsg(), errorOrderMsg);
        int orderNumber = checkoutPage.getOrderNumber();
        softAssert.assertTrue(checkoutPage.isCorrectBillingInfoSaved(fName.concat(" ").concat(lName), email, street), errorBillingAddress);

        myAccountPage = navigationBar.goToMyAccountPage();
        softAssert.assertTrue(homePage.verifyTitle("My Account"), pageLoadFail("MyAccountPage"));

        ordersPage = myAccountPage.goToOrders();
        softAssert.assertTrue(ordersPage.isSameOrderNumber(orderNumber), errorOrderNumber);
        Thread.sleep(1000);
        myAccountPage.logout();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }
}
