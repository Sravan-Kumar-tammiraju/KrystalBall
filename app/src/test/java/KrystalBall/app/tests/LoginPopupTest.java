package KrystalBall.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import KrystalBall.app.Base.BaseTest;

public class LoginPopupTest extends BaseTest {

    @Test(priority = 3, groups = {"regression", "authentication", "ui"})
    public void verifyLoginPopupDisplayed() {

        landingPage.clickGetStarted();

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        alcoholTypesPage.selectAlcoholCardByIndex(1);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed"
        );

        System.out.println("PASS: Login popup displayed successfully");
    }
}