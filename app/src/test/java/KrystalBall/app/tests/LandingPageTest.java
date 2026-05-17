package KrystalBall.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import KrystalBall.app.Base.BaseTest;

public class LandingPageTest extends BaseTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void verifyLandingPage() {

        Assert.assertTrue(
                landingPage.isLandingPageOpened(),
                "Landing page is not opened"
        );

        System.out.println("PASS: Landing page loaded successfully");
    }
}