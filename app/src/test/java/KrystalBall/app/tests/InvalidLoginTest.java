package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void verifyInvalidLogin() {

        // Click Get Started
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        // Handle age popup if displayed
        handleAgeVerificationPopup();

        // Get all alcohol cards
        List<WebElement> cards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'cursor-pointer')]")
                )
        );

        // Click first visible card
        for (WebElement card : cards) {

            if (card.isDisplayed()) {

                card.click();
                break;
            }
        }

        // Verify login popup displayed
        WebElement loginPopup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Get Started Now')]")
                )
        );

        Assert.assertTrue(loginPopup.isDisplayed());

        // Enter invalid email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[contains(@placeholder,'email')]")
                )
        );

        emailField.sendKeys("testinvalid@gmail.com");

        // Enter invalid password
        WebElement passwordField = driver.findElement(
                By.xpath("//input[contains(@placeholder,'password')]")
        );

        passwordField.sendKeys("#Enternumeric1");

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Login')]")
        )).click();

        // Verify Invalid Credentials popup
        WebElement invalidToast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'Invalid Credentials!')]")
                )
        );

        Assert.assertTrue(invalidToast.isDisplayed());

        System.out.println("PASS: Invalid credentials popup displayed successfully");
    }
}