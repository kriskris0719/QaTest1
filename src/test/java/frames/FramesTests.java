package frames;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTest {

    @Test
    public void testFrameText() {
        homePage.clickLinkPage("Frames");
        NestedFramesPage nestedFramesPage = framesPage.clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT", "Text is incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(),"BOTTOM", "Text is incorrect");
    }
}
