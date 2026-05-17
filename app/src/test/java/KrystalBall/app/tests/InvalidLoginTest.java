package KrystalBall.app.tests;

import KrystalBall.app.Base.BaseTest;
import KrystalBall.app.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 8, groups = {"regression", "authentication"})
    public void verifyInvalidLogin() {

        String email = ConfigReader.getProperty("invalidEmail");
        String password = ConfigReader.getProperty("invalidPassword");

        landingPage.clickGetStarted();

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        alcoholTypesPage.selectAlcoholCardByIndex(0);

        alcoholTypesPage.handleAgeVerificationPopupIfPresent();

        Assert.assertTrue(
                loginPage.isLoginPopupDisplayed(),
                "Login popup is not displayed"
        );

        loginPage.loginWithCredentials(email, password);

        Assert.assertTrue(
                loginPage.isInvalidCredentialsToastDisplayed(),
                "Invalid credentials toast is not displayed"
        );

        System.out.println("PASS: Invalid credentials validation successful");
    }
}