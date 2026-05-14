package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPopupTest extends BaseTest {

    @Test
    public void verifyLoginPopupDisplayed() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        handleAgeVerificationPopup();

        // Select second alcohol card
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'cursor-pointer')])[2]")
        )).click();

        WebElement popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Get Started Now')]")
                )
        );

        Assert.assertTrue(popup.isDisplayed());

        System.out.println("PASS: Login popup displayed successfully");
    }
}