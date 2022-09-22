package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertTests extends BaseTest {

    @Test
    public void testAcceptAlert(){
        homePage.clickLinkPage("JavaScript Alerts");
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
    }
}
