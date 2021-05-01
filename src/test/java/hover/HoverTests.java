package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverWomen() {
        var desktopNavbar = homePage.clickHovers();
        desktopNavbar.hoverOverFigure("//span[contains(text(),'Women')]");
        assertTrue(desktopNavbar.isCaptionDisplayed(), "Desktop Navbar Item is not being displayed");
        assertEquals(desktopNavbar.getLinkText(), "Women", "link text incorrect");
    }

    @Test
    public void testHoverMen() {
        var desktopNavbar = homePage.clickHovers();
        desktopNavbar.hoverOverFigure("//span[contains(text(),'Men')]");
        assertTrue(desktopNavbar.isCaptionDisplayed(), "Desktop Navbar Item is not being displayed");
        assertEquals(desktopNavbar.getLinkText(), "Men", "link text incorrect");
    }

    @Test
    public void testHoverDesigners() {
        var desktopNavbar = homePage.clickHovers();
        desktopNavbar.hoverOverFigure("//span[contains(text(),'Designers')]");
        assertTrue(desktopNavbar.isCaptionDisplayed(), "Desktop Navbar Item is not being displayed");
        assertEquals(desktopNavbar.getLinkText(), "Designers", "link text incorrect");
    }

    @Test
    public void testHoverHowItWorks() {
        var desktopNavbar = homePage.clickHovers();
        desktopNavbar.hoverOverFigure("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]");
        assertTrue(desktopNavbar.isCaptionDisplayed(), "Desktop Navbar Item is not being displayed");
        assertEquals(desktopNavbar.getLinkText(), "How it Works", "link text incorrect");
    }

    @Test
    public void testGiftCards() {
        var desktopNavbar = homePage.clickHovers();
        desktopNavbar.hoverOverFigure("//span[contains(text(),'Gift Cards')]");
        assertTrue(desktopNavbar.isCaptionDisplayed(), "Desktop Navbar Item is not being displayed");
        assertEquals(desktopNavbar.getLinkText(), "Gift Cards", "link text incorrect");
    }
}
