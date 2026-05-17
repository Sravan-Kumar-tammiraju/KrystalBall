package KrystalBall.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import KrystalBall.app.Base.BaseTest;

public class ContinueWithoutAccountTest extends BaseTest {

    @Test(priority = 4, groups = {"smoke", "regression", "guest"})
    public void verifyContinueWithoutAccount() {

        landingPage.clickGetStarted();

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        alcoholTypesPage.selectAlcoholCardByIndex(2);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        loginPage.clickContinueWithoutAccount();

        Assert.assertTrue(
                productsPage.isSearchInputDisplayed(),
                "Search input is not displayed after continuing without account"
        );

        System.out.println("PASS: Continue without account successful");
    }
}