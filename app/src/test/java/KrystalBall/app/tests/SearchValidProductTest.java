package KrystalBall.app.tests;

import KrystalBall.app.Base.BaseTest;
import KrystalBall.app.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchValidProductTest extends BaseTest {

    @Test(priority = 5, groups = {"regression", "search"})
    public void verifySearchWithValidProduct() {

        String productName = ConfigReader.getProperty("validProduct");

        landingPage.clickGetStarted();

        alcoholTypesPage.selectAlcoholCardByIndex(0);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        loginPage.clickContinueWithoutAccountIfPresent();

        productsPage.searchProduct(productName);

        Assert.assertTrue(
                productsPage.isProductDisplayed(productName),
                "Valid product is not displayed in search results"
        );

        System.out.println("PASS: Valid product search successful");
    }
}