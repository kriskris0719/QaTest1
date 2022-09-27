package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
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
    protected DynamicLoadingExample2Page dynamicLoadingExample2Page;
    protected LargeAndDeepDomPage largeAndDeepDomPage;
    protected InfiniteScrollPage infiniteScrollPage;
    protected WindowManager windowManager;
    protected MultipleWindowsPage multipleWindowsPage;
    protected ButtonPage buttonPage;




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
        dynamicLoadingExample2Page = new DynamicLoadingExample2Page(driver);
        largeAndDeepDomPage = new LargeAndDeepDomPage(driver);
        infiniteScrollPage = new InfiniteScrollPage(driver);
        windowManager = new WindowManager(driver);
        multipleWindowsPage = new MultipleWindowsPage(driver);
        buttonPage = new ButtonPage(driver);



    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod
    public void recordFailure(ITestResult result) {

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot, new File("C:\\GIT\\QaTest1\\src\\test\\resources\\screenshots\\" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

}