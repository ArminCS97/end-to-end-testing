package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver;

    private By usernameField = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
    private By passwordField = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public FailedLoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        WebElement result = new WebDriverWait(driver, 20).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Invalid email or password.')]"))
        );
        return new FailedLoginPage(driver);
    }
}
