package KrystalBall.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import KrystalBall.app.Base.BasePage;

import java.util.List;

public class ProductsPage extends BasePage {

    private By searchInput = By.xpath("//input[contains(@placeholder,'Search')]");

    private By productCards = By.cssSelector("div");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchInputDisplayed() {

        return isDisplayed(searchInput);
    }

    public void searchProduct(String productName) {

        type(searchInput, productName);
    }

    public boolean isProductDisplayed(String productName) {

        By productText = By.xpath("//*[contains(text(),'" + productName + "')]");

        return isDisplayed(productText);
    }

    public boolean isInvalidProductNotDisplayed(String productName) {

        List<WebElement> matchingVisibleElements = driver.findElements(
                By.xpath("//*[contains(text(),'" + productName + "')]"));

        for (WebElement element : matchingVisibleElements) {

            if (element.isDisplayed()) {
                return false;
            }
        }

        return true;
    }
}