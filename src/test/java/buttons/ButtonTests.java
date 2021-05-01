package buttons;

import base.BaseTests;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class ButtonTests extends BaseTests {

    @Test
    public void testShopHere() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//a[contains(text(),'SHOP HERE')]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testImageLogoLink() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[1]/div[1]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testNewWomesDresses() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[3]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testSonderBrand() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//a[contains(text(),'Sonder the Brand')]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testMenAll() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    // failing test
    @Test
    public void testPrivacyPolicy() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//span[contains(text(),'Privacy Policy')]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testAllDesigners() throws IOException {
        var button = homePage.buttonHandler();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }



}
