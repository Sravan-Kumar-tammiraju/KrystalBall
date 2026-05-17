package KrystalBall.app.Base;

import KrystalBall.app.pages.AlcoholTypesPage;
import KrystalBall.app.pages.LandingPage;
import KrystalBall.app.pages.LoginPage;
import KrystalBall.app.pages.ProductsPage;
import KrystalBall.app.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected LandingPage landingPage;
    protected AlcoholTypesPage alcoholTypesPage;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("baseUrl"));

        landingPage = new LandingPage(driver);
        alcoholTypesPage = new AlcoholTypesPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}