package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonPage {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");


    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }

}
