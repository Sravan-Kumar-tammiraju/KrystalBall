package KrystalBall.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import KrystalBall.app.Base.BasePage;

public class LandingPage extends BasePage {

    private By getStartedButton =
            By.xpath("//*[contains(text(),'Get started')]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLandingPageOpened() {

        return driver.getCurrentUrl().contains("smartpad-customer-feedback");
    }

    public void clickGetStarted() {

        click(getStartedButton);
    }
}