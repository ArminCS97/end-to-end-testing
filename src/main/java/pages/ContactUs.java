package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
    private WebDriver driver;
    private final By contactUsMenu = By.xpath("//span[contains(text(),'Contact Us')]");
    private final By firstNameLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]");
    private final By lastNameLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[2]/input[1]");
    private final By emailLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]");
    private final By subjectLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]/input[1]");
    private final By messageLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/textarea[1]");
    private final By sendButtonLocator = By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[2]/button[1]");

    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }

    public void fillTheForm(String firstName, String lastName, String email, String subject, String message) {
        driver.findElement(contactUsMenu).click();
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(subjectLocator).sendKeys(subject);
        driver.findElement(messageLocator).sendKeys(message);
    }

    public String sendTheForm() {
        // Now we send the feedback as we are on the dev environment so it is ok.
        driver.findElement(sendButtonLocator).click();
        WebElement wait = new WebDriverWait(driver, 20).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]"))
        );
        WebElement result = driver.findElement(By.xpath("//h3[contains(text(),'Message Received!')]"));
        return result.getText();
    }
}
