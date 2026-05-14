package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlcoholTypesTest extends BaseTest {

    @Test
    public void verifyAlcoholTypesNavigation() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        handleAgeVerificationPopup();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'cursor-pointer')])[1]")
        )).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("products"));

        System.out.println("Alcohol types page opened successfully");
    }
}