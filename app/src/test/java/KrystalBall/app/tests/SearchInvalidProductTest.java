package KrystalBall.app.tests;

import KrystalBall.app.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchInvalidProductTest extends BaseTest {

    @Test
    public void verifySearchWithInvalidProduct() {

        // Click Get Started
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Get started')]")
        )).click();

        // Select alcohol tile
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'cursor-pointer')])[2]")
        )).click();

        // Handle age popup
        handleAgeVerificationPopup();

        // Continue without account
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Continue without an account')]")
        )).click();

        // Search invalid product
        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[contains(@placeholder,'Search')]")
                )
        );

        searchField.sendKeys("dfgfdgt");

        // Verify no matching products
        List<WebElement> products =
                driver.findElements(By.xpath("//*[contains(text(),'dfgfdgt')]"));

        Assert.assertTrue(products.isEmpty());

        System.out.println("PASS: No matching products displayed");
    }
}