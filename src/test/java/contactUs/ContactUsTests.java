package contactUs;

import pages.ContactUs;

import base.BaseTests;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ContactUsTests extends BaseTests {
    private ContactUs contactUs = homePage.contactUs();

    @Test
    public void testContactUs() {
        contactUs.fillTheForm("Armin", "Felahat", "armin@gmail.com", "Appreciation",
                "All looks great");
        String result = contactUs.sendTheForm();
        assertEquals(result, "Message Received!", "Process has failed");
    }

}
