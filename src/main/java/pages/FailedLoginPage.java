package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FailedLoginPage {

    private WebDriver driver;
    private By statusAlert = By.xpath("//p[contains(text(),'Invalid email or password.')]");

    public FailedLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }

    public boolean isDispalyed() {
        return driver.findElement(statusAlert).isDisplayed();
    }
}
