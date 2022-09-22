package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.HorizontalSliderPage;
import pages.KeyPressesPage;

public class BaseTest {

    private WebDriver driver;

    protected HomePage homePage;
    protected KeyPressesPage keyPressesPage;
    protected HorizontalSliderPage horizontalSliderPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        keyPressesPage = new KeyPressesPage(driver);
        horizontalSliderPage = new HorizontalSliderPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}