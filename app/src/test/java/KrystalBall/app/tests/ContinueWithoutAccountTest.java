package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContinueWithoutAccountTest extends BaseTest {

        @Test
        public void verifyContinueWithoutAccount() {

                // Click Get Started
                wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//*[contains(text(),'Get started')]"))).click();

                // Handle popup after page transition
                handleAgeVerificationPopup();

                // Select third alcohol card
                WebElement alcoholCard = wait.until(
                                ExpectedConditions.presenceOfElementLocated(
                                                By.xpath("(//div[contains(@class,'cursor-pointer')])[3]")));

                // Scroll into view
                ((JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView(true);",
                                                alcoholCard);

                // Handle popup AGAIN before clicking
                handleAgeVerificationPopup();

                // Click card
                wait.until(ExpectedConditions.elementToBeClickable(
                                alcoholCard)).click();

                // Handle popup AGAIN after clicking
                handleAgeVerificationPopup();

                // Continue without account
                wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//*[contains(text(),'Continue without an account')]"))).click();

                // Verify products page loaded
                wait.until(ExpectedConditions.urlContains("/products"));

                WebElement searchBar = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(
                                                By.xpath("//input[contains(@placeholder,'Search')]")));

                Assert.assertTrue(searchBar.isDisplayed());

                System.out.println("PASS: Continue without account successful");
        }
}