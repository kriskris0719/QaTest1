package slider;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HorizontalSliderTests extends BaseTest {

    @Test
    public void testSlider(){
        String value = "4";
        HorizontalSliderPage sliderPage = homePage.clickHorizontalSlider();
        sliderPage.moveSlider(value);
        assertEquals(sliderPage.moveSlider(), value, "Slider value is incorrect!");

    }

}
