package tests.smoke_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;
import test_components.BaseTest;

import java.io.IOException;

import static test_components.Utilities.*;

public class E2ETest extends BaseTest {

    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected SearchPage searchPage;
    protected ProductPage productPage;


    @BeforeTest
    public void setUp() throws IOException {
        driver = initializeDriver();

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
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
        productPage.addToCart();

        productPage.getSuccessMsg();




    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
        softAssert.assertAll();
    }










}
