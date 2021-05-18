package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;

    // Accepting cookies. This basically avoids the ElementClickInterceptedException when we will use other buttons
    private void clickCookiesPanel () {
        driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
        // This 15 seconds is the maximum time that it can take to disappear.
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HoversPage clickHovers() {
        return new HoversPage(driver);
    }

    public AddToCart cart() {
        clickCookiesPanel();
        return new AddToCart(driver);
    }

    public AllTheHomePageButtonLinks allTheHomePageButtonLinks() {
        return new AllTheHomePageButtonLinks(driver);
    }

    public Login login() {
        return new Login(driver);
    }

    public Search search() {
        return new Search(driver);
    }

    public ContactUs contactUs() {
        clickCookiesPanel();
        return new ContactUs(driver);
    }

}