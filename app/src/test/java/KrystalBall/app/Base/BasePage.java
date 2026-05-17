package KrystalBall.app.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitForAllVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void click(By locator) {

        waitForClickable(locator).click();
    }

    protected void type(By locator, String value) {

        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected boolean isDisplayed(By locator) {

        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void jsClick(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element
        );
    }

    protected boolean isTextPresent(String text) {

        return driver.getPageSource().contains(text);
    }
}