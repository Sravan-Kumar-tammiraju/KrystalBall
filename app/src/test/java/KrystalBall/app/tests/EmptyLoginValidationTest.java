package KrystalBall.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import KrystalBall.app.Base.BaseTest;

public class EmptyLoginValidationTest extends BaseTest {

    @Test(priority = 7, groups = {"regression", "authentication"})
    public void verifyEmptyLoginValidation() {

        landingPage.clickGetStarted();

        alcoholTypesPage.selectAlcoholCardByIndex(0);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed"
        );

        loginPage.clickLoginButton();

        Assert.assertTrue(
                loginPage.isEmptyEmailValidationDisplayed(),
                "Empty email validation is not displayed"
        );

        System.out.println("PASS: Empty login validation successful");
    }
}