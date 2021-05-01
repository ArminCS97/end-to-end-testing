package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ButtonHandler {
    private WebDriver driver;
    private WebElement button;

    public ButtonHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkText(String xPath) {
        this.button = driver.findElement(By.xpath(xPath));
    }

    public boolean isLinkBroken() throws IOException {
        String linkUrl = button.getAttribute("href");
        URL url = new URL(linkUrl);
        HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
        httpURLConnect.setConnectTimeout(5000);
        httpURLConnect.connect();
        //Fetching and Printing the response code obtained
        return httpURLConnect.getResponseCode() < 400;
    }
}
