package examples;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {

    @Test
    public void testWaitUntilHidden(){
        homePage.clickLinkPage("Dynamic Loading");
        dynamicLoadingPage.clickExample1();
        dynamicLoadingExample1Page.clickStart();
        assertEquals(dynamicLoadingExample1Page.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}
