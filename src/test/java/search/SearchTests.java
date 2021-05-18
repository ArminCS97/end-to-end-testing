package search;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Search;

import java.util.List;

import static org.testng.Assert.*;

// Search functionality plus its logic will change completely soon.
// So We cannot have exhaustive cases.
public class SearchTests extends BaseTests {

    @Test
    public void testSearchBar() {
        Search search = homePage.search();
        search.setKeyword("date");
        List results = search.getResultsTest();
        // Search for that keyword should have these items always
        assertTrue(search.isResultDisplayed(), "Should be displayed");
        assertTrue(results.contains("Date Night In"), "Does not contain Date Night In");
        assertTrue(results.contains("Valentine's Day"), "Does not contain Women Pins");

        List parts = search.getResultParts();
        assertFalse(parts.contains("Category"), "Category Part must exist.");
        assertFalse(parts.contains("Designer"), "Designer Part must exist.");
        assertTrue(parts.contains("Occasion"), "Occasion Part must exist.");
    }

    @Test
    public void testSearchBar2() {
        Search search = homePage.search();
        search.setKeyword("d");
        List results = search.getResultsTest();
        assertTrue(search.isResultDisplayed(), "Should be displayed");
        for (Object result: results) {
            boolean hasTheKeyword = ((String)result).contains("d") || ((String)result).contains("D");
            assertTrue(hasTheKeyword, "Result should contain the keyword 'd' or 'D'");
        }

        List parts = search.getResultParts();
        assertFalse(parts.contains("Category"), "Category Part must exist.");
        assertTrue(parts.contains("Designer"), "Designer Part must exist.");
        assertTrue(parts.contains("Occasion"), "Occasion Part must exist.");
    }

    @Test
    public void testSearchBar3() {
        Search search = homePage.search();
        search.setKeyword("br");
        assertTrue(search.isResultDisplayed(), "Should be displayed");
        List results = search.getResultsTest();
        for (Object result: results) {
            boolean hasTheKeyword = ((String)result).contains("br") || ((String)result).contains("BR") ||
                    ((String)result).contains("Br") || ((String)result).contains("bR");
            assertTrue(hasTheKeyword, "Result should contain the keyword 'Br', 'BR', 'bR', or 'br'.");
        }

        List parts = search.getResultParts();
        assertFalse(parts.contains("Category"), "Category Part must exist.");
        assertTrue(parts.contains("Designer"), "Designer Part must exist.");
        assertTrue(parts.contains("Occasion"), "Occasion Part must exist.");
    }

    @Test
    public void testSearchBar4() {
        Search search = homePage.search();
        search.setKeyword("b");
        assertTrue(search.isResultDisplayed(), "Should be displayed");
        List results = search.getResultsTest();
        for (Object result : results) {
            boolean hasTheKeyword = ((String) result).contains("b") || ((String) result).contains("B");
            assertTrue(hasTheKeyword, "Result should contain the keyword 'B' or 'b'");
        }

        List parts = search.getResultParts();
        assertTrue(parts.contains("Category"), "Category Part must exist.");
        assertTrue(parts.contains("Designer"), "Designer Part must exist.");
        assertTrue(parts.contains("Occasion"), "Occasion Part must exist.");
    }

}
