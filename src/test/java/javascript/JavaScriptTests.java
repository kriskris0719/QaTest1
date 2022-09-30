package javascript;

import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {

    @Test
    public void testScrollToTable(){
        homePage.clickLinkPage("Large & Deep DOM");
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickLinkPage("Infinite Scroll");
        infiniteScrollPage.scrollToParagraph(5);
    }
}
