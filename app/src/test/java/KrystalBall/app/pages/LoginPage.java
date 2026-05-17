package KrystalBall.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import KrystalBall.app.Base.BasePage;

public class LoginPage extends BasePage {

    private By loginPopupTitle =
            By.xpath("//*[contains(text(),'Get Started Now')]");

    private By continueWithoutAccountButton =
            By.xpath("//*[contains(text(),'Continue without an account')]");

    private By emailInput =
            By.xpath("//input[contains(@placeholder,'email')]");

    private By passwordInput =
            By.xpath("//input[contains(@placeholder,'password')]");

    private By loginButton =
            By.xpath("//*[contains(text(),'Login')]");

    private By emptyEmailValidation =
            By.xpath("//div[text()='Please enter your email']");

    private By invalidCredentialsToast =
            By.xpath("//div[contains(text(),'Invalid Credentials!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPopupDisplayed() {

        return isDisplayed(loginPopupTitle);
    }

    public void clickContinueWithoutAccountIfPresent() {

        try {
            click(continueWithoutAccountButton);
        } catch (TimeoutException e) {
            System.out.println("Continue without account option not displayed");
        }
    }

    public void clickContinueWithoutAccount() {

        click(continueWithoutAccountButton);
    }

    public void clickLoginButton() {

        click(loginButton);
    }

    public void loginWithCredentials(String email, String password) {

        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
    }

    public boolean isEmptyEmailValidationDisplayed() {

        return isDisplayed(emptyEmailValidation);
    }

    public boolean isInvalidCredentialsToastDisplayed() {

        return isDisplayed(invalidCredentialsToast);
    }
}