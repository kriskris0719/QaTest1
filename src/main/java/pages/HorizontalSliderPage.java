package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderRange = By.xpath("//div/span");
    private By slider = By.xpath("//div/input");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider(String value) {
        WebElement slider = driver.findElement(By.xpath("//div/input"));
        Actions moveSlider = new Actions(driver);
        Actions action = moveSlider.dragAndDropBy(slider, 4, 0);
        action.perform();
    }

    public String moveSlider() {
        return driver.findElement(slider).getText();
    }
}

