package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTest {

    @Test
    public void testAcceptAlert(){
        homePage.clickLinkPage("JavaScript Alerts");
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Results text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        homePage.clickLinkPage("JavaScript Alerts");
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        homePage.clickLinkPage("JavaScript Alerts");
        alertsPage.triggerPrompt();
        String text = "TAU Rocks";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " +text, "Results text incorrect");
    }
}
