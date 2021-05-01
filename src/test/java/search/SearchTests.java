package search;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.Search;

import java.util.List;

import static org.testng.Assert.*;

public class SearchTests extends BaseTests {

    @Test
    public void testSearchBar() {
        Search search = homePage.search();
        search.setKeyword("Women");
        List results = search.getResultsTest();
        // Search for that keyword should have these items always
        assertTrue(results.contains("Women Sweaters"), "Does not contain Women Sweaters");
        assertTrue(results.contains("Women Pins"), "Does not contain Women Pins");
        assertTrue(results.contains("Women Vests"), "Does not contain Women Vests");
    }

    @Test
    public void testSearchBar2() {
        Search search = homePage.search();
        search.setKeyword("W");
        List results = search.getResultsTest();
        for (Object result: results) {
            assertTrue(((String)result).startsWith("W"), "Result should start with the keyword 'w'");
        }
    }

    @Test
    public void testSearchBar3() {
        Search search = homePage.search();
        search.setKeyword("W");
        List results = search.getResultsTest();
        for (Object result: results) {
            assertFalse(((String)result).startsWith("M"), "Result should start with the keyword 'w'");
        }
    }
}
