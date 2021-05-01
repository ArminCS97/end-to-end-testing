package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HoversPage clickHovers() {
        return new HoversPage(driver);
    }

    public ButtonHandler buttonHandler() {
        return new ButtonHandler(driver);
    }

    public Login login() {
        findAndClickByXpath("//body/div[@id='root']/nav[1]/div[1]/div[1]/ul[2]/li[4]/img[1]");
        findAndClickByXpath("//a[contains(text(),'Log In')]");
        // 7 seconds in the worst case scenario is fine.
        // And I wanted to intentionally use this implicit waiting mechanism for my HW.
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        return new Login(driver);
    }

    public Search search() {
        return new Search(driver);
    }


    private void findAndClickByXpath(String path) {
       driver.findElement(By.xpath(path)).click();
    }

}