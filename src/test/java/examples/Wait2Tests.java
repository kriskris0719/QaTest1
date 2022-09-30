package examples;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Wait2Tests extends BaseTest {

    @Test
    public void testWaitUntilVisible(){
        homePage.clickLinkPage("Dynamic Loading");
        dynamicLoadingPage.clickExample2();
        dynamicLoadingExample2Page.clickStart();
        assertEquals(dynamicLoadingExample2Page.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}
