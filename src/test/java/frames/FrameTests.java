package frames;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTest {

    @Test

    public void testWysiwyg() {

        homePage.clickLinkPage("WYSIWYG Editor");
        wysiwygEditorPage.clearTextArea();
        String text0 = "Your content goes here.";
        String text1 = "hello ";
        String text2 = "world";
        wysiwygEditorPage.setTextArea(text0);
        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);

        assertEquals(wysiwygEditorPage.getTextFromEditor(), text0+text1+text2, "Text from editor is incorrect");
    }
}
