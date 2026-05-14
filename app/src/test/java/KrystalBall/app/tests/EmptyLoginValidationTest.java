package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyLoginValidationTest extends BaseTest {

    @Test
    public void verifyEmptyLoginValidation() {

        // Click Get Started
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        // Select alcohol tile
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'cursor-pointer')])[3]")
        )).click();

        // Handle age popup
        handleAgeVerificationPopup();

        // Verify login popup
        WebElement popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Get Started Now')]")
                )
        );

        Assert.assertTrue(popup.isDisplayed());

        // Click Login button without entering credentials
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(),'Login')]")
        )).click();

        // Verify validation behavior
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[text()='Please enter your email']")
                )
        );

        Assert.assertTrue(emailField.isDisplayed());

        System.out.println("PASS: Empty login validation working successfully");
    }
}