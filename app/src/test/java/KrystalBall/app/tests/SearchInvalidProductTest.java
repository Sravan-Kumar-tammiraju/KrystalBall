package KrystalBall.app.tests;

import KrystalBall.app.Base.BaseTest;
import KrystalBall.app.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchInvalidProductTest extends BaseTest {

    @Test(priority = 6, groups = {"regression", "search"})
    public void verifySearchWithInvalidProduct() {

        String invalidProduct = ConfigReader.getProperty("invalidProduct");

        landingPage.clickGetStarted();

        alcoholTypesPage.selectAlcoholCardByIndex(0);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        loginPage.clickContinueWithoutAccountIfPresent();

        productsPage.searchProduct(invalidProduct);

        Assert.assertTrue(
                productsPage.isInvalidProductNotDisplayed(invalidProduct),
                "Invalid product text should not be displayed"
        );

        System.out.println("PASS: Invalid product search validation successful");
    }
}