package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.EventReporter;
import utils.WindowManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private EventFiringWebDriver driver;


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
    protected DynamicLoadingExample2Page dynamicLoadingExample2Page;
    protected LargeAndDeepDomPage largeAndDeepDomPage;
    protected InfiniteScrollPage infiniteScrollPage;
    protected WindowManager windowManager;
    protected MultipleWindowsPage multipleWindowsPage;
    protected ButtonPage buttonPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        //setCookie();
        //deleteCookie();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        dynamicLoadingExample2Page = new DynamicLoadingExample2Page(driver);
        largeAndDeepDomPage = new LargeAndDeepDomPage(driver);
        infiniteScrollPage = new InfiniteScrollPage(driver);
        windowManager = new WindowManager(driver);
        multipleWindowsPage = new MultipleWindowsPage(driver);
        buttonPage = new ButtonPage(driver);
    }

    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*@AfterMethod
    public void recordFailure(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("C:\\GIT\\QaTest1\\src\\test\\resources\\screenshots\\" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(true);
        return options;
    }

    /*private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }*/

  /*  private void deleteCookie() {
        Cookie cookie = new Cookie.Builder("optimizelyBuckets", "%7B%TD")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().deleteCookie(cookie);
    }*/

}