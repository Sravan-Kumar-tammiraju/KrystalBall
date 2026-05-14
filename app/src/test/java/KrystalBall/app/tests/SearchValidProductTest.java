package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchValidProductTest extends BaseTest {

    @Test
    public void verifySearchWithValidProduct() throws InterruptedException {

        // Click Get Started
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        // Select alcohol card
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Whisky')]")
        )).click();

        // Handle age verification popup if present
        handleAgeVerificationPopup();

        // Click Continue without account if popup appears
        try {

            WebElement continueButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//*[contains(text(),'Continue without an account')]")
                    )
            );

            continueButton.click();

        } catch (Exception e) {

            System.out.println("Login popup not displayed");
        }

        // Search field
        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[contains(@placeholder,'Search')]")
                )
        );

        // Clear and enter product
        searchField.clear();
        searchField.sendKeys("Amrut");

        // Wait briefly for filtering
        Thread.sleep(2000);

        // Verify at least one Amrut product displayed
        List<WebElement> matchingProducts =
                driver.findElements(
                        By.xpath("//*[contains(text(),'Amrut')]")
                );

        Assert.assertFalse(matchingProducts.isEmpty());

        System.out.println("PASS: Matching products displayed successfully");
    }
}