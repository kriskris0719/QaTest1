package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formKeyPressesLink = By.linkText("Key Presses");
    private By formHorizontalSliderLink = By.linkText("Horizontal slider");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public KeyPressesPage clickKeyPresses(){
        driver.findElement(formKeyPressesLink).click();
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        driver.findElement(formHorizontalSliderLink).click();
        return new HorizontalSliderPage(driver);
    }

    public void clickLinkPage(String textPage){
        driver.findElement(By.linkText(textPage)).click();

    }
}