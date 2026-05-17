package KrystalBall.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import KrystalBall.app.Base.BaseTest;

public class AlcoholTypesTest extends BaseTest {

    @Test(priority = 2, groups = {"smoke", "regression", "navigation"})
    public void verifyAlcoholTypesNavigation() {

        landingPage.clickGetStarted();

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        alcoholTypesPage.selectAlcoholCardByIndex(0);

        Assert.assertTrue(
                alcoholTypesPage.isProductsPageOpened(),
                "Products page is not opened after selecting alcohol type"
        );

        System.out.println("PASS: Alcohol type navigation successful");
    }
}