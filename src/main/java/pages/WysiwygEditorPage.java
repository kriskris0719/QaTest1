package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.xpath("//*[@id=\"tinymce\"]");
    private By decreaseIndentButton = By.cssSelector("button[title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditArea() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
    }
}
