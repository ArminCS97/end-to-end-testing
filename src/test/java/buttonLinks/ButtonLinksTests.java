package buttonLinks;

import base.BaseTests;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class ButtonLinksTests extends BaseTests {

    @Test
    public void testFacebookIcon() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//tbody/tr[2]/td[1]/footer[1]/div[1]/div[1]/div[3]/div[1]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testInstagramIcon() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//tbody/tr[2]/td[1]/footer[1]/div[1]/div[1]/div[3]/div[1]/a[2]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testLinkedDinIcon() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//tbody/tr[2]/td[1]/footer[1]/div[1]/div[1]/div[3]/div[1]/a[3]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testImageLogoLink() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[1]/div[1]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testNewWomesDresses() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[3]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testHowItWorks() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//tbody/tr[2]/td[1]/footer[1]/div[1]/div[1]/div[2]/div[2]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testMenAll() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    // failing test
    @Test
    public void testPrivacyPolicy() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//span[contains(text(),'Privacy Policy')]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

    @Test
    public void testAllDesigners() throws IOException {
        var button = homePage.allTheHomePageButtonLinks();
        button.clickLinkText("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]");
        assertTrue(button.isLinkBroken(), "Link is broken");
    }

}
