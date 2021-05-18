package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Login;


import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testFailedLogin() {
        Login loginPage = homePage.login();
        loginPage.setUsername("armintdudbdn@gmail.com");
        loginPage.setPassword("1234445ghfhfgfg");
        Login.FailedLoginPage failedLoginPage = loginPage.clickLoginButton();
        assertTrue(failedLoginPage.isDispalyed(), "It is not being displayed");
        assertTrue(failedLoginPage.getAlertText().contains("Invalid email or password"), "Alert text is incorrect");
    }
}
