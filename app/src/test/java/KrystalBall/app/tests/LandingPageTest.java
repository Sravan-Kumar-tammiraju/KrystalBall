package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {

    @Test
    public void verifyLandingPage() {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("smartpad-customer-feedback"));

        System.out.println("Landing page loaded successfully");
    }
}