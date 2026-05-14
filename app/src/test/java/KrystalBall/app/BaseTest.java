package KrystalBall.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://smartpad-customer-feedback.vercel.app/");
    }

    // GLOBAL AGE POPUP HANDLER
    protected void handleAgeVerificationPopup() {

    try {

        WebDriverWait popupWait =
                new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement yesButton = popupWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Yes']")
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", yesButton);

        System.out.println("Age verification popup handled");

    } catch (Exception e) {

        // Ignore if popup not present
    }
}

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}