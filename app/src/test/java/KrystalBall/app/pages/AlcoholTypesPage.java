package KrystalBall.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import KrystalBall.app.Base.BasePage;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class AlcoholTypesPage extends BasePage {

    private By alcoholCards =
            By.cssSelector("div.cursor-pointer");

    private By yesButton =
            By.xpath("//button[normalize-space()='Yes']");

    public AlcoholTypesPage(WebDriver driver) {
        super(driver);
    }

    public void handleAgeVerificationPopupIfPresent() {

        try {
            WebDriverWait shortWait =
                    new WebDriverWait(driver, Duration.ofSeconds(4));

            WebElement yes = shortWait.until(
                    ExpectedConditions.elementToBeClickable(yesButton)
            );

            jsClick(yes);

            System.out.println("Age verification popup handled");

        } catch (TimeoutException e) {

            System.out.println("Age verification popup not displayed");
        }
    }

    public void selectAlcoholCardByIndex(int index) {

        handleAgeVerificationPopupIfPresent();

        for (int attempt = 1; attempt <= 3; attempt++) {

            try {

                List<WebElement> cards = wait.until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(alcoholCards)
                );

                if (cards.size() == 0) {
                    throw new RuntimeException("No alcohol cards found on the page");
                }

                int safeIndex = Math.min(index, cards.size() - 1);

                WebElement card = wait.until(
                        ExpectedConditions.elementToBeClickable(cards.get(safeIndex))
                );

                scrollToElement(card);

                jsClick(card);

                System.out.println("Alcohol card selected successfully");

                return;

            } catch (StaleElementReferenceException e) {

                System.out.println("Stale element found while selecting alcohol card. Retrying attempt: " + attempt);
            }
        }

        throw new RuntimeException("Unable to select alcohol card after retrying");
    }

    public boolean isProductsPageOpened() {

        return driver.getCurrentUrl().contains("products");
    }
}