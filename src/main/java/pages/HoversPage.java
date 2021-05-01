package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage {
    private WebDriver driver;
    private WebElement figure;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverFigure(String xPath) {
        this.figure = driver.findElement(By.xpath(xPath));
    }

    public boolean isCaptionDisplayed() {
        return figure.isDisplayed();
    }

    public String getLinkText() {
        return figure.getText();
    }
}
