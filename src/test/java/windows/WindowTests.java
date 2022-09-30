package windows;

import base.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTest {

    @Test
    public void testWindowTabs() {
        homePage.clickLinkPage("Dynamic Loading");
        dynamicLoadingPage.rightClickOnExample2Link();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
