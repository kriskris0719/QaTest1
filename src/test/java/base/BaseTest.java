package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    protected HomePage homePage;
    protected KeyPressesPage keyPressesPage;
    protected HorizontalSliderPage horizontalSliderPage;
    protected AlertsPage alertsPage;
    protected FileUploadPage fileUploadPage;
    protected ContextMenuPage contextMenuPage;
    protected WysiwygEditorPage wysiwygEditorPage;
    protected FramesPage framesPage;
    protected NestedFramesPage nestedFramesPage;
    protected DynamicLoadingPage dynamicLoadingPage;
    protected DynamicLoadingExample1Page dynamicLoadingExample1Page;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        keyPressesPage = new KeyPressesPage(driver);
        horizontalSliderPage = new HorizontalSliderPage(driver);
        alertsPage = new AlertsPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        wysiwygEditorPage = new WysiwygEditorPage(driver);
        framesPage = new FramesPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingExample1Page = new DynamicLoadingExample1Page(driver);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}