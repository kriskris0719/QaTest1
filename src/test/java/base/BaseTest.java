package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
        private WebDriver driver;
        protected HomePage homePage;

        @BeforeTest
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
            homePage = new HomePage(driver);
        }

        @AfterTest(alwaysRun = true)
        public void tearDown() {
            driver.quit();
        }
    }