package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ButtonPage {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");


    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStartButtonDisplayed(){
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return driver.findElement(startButton).isDisplayed();
    }

}
