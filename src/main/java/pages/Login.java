package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver;

    private final By loginIcon = By.xpath("//body/div[@id='root']/nav[1]/div[1]/div[1]/ul[2]/li[4]/img[1]");
    private final By loginIconButton = By.xpath("//a[contains(text(),'Log In')]");


    private By usernameField = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
    private By passwordField = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public Login(WebDriver driver) {
        this.driver = driver;
        driver.findElement(loginIcon).click();
        driver.findElement(loginIconButton).click();
        // 7 seconds in the worst case scenario is fine.
        // And I wanted to intentionally use this implicit waiting mechanism too.
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
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
}



