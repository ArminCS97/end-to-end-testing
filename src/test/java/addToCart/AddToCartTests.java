package addToCart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddToCart;

import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.*;

public class AddToCartTests extends BaseTests {
    @Test
    public void addItem() {
        AddToCart addToCart = homePage.cart();
        addToCart.addItem1();
        addToCart.goToCart();
        List<String> items = addToCart.getCartItems();
        Hashtable<String, String> priceDict = addToCart.getTotalPrice();
        assertTrue(items.contains("this is item 1 by new brand"), "List must contain the item specified");
        assertTrue(items.contains("26,186,823 AMD"), "List must contain the price of the item specified");
        assertTrue(items.contains("European 56 M"), "List must contain the size of the item specified");
        assertTrue(items.contains("Size"), "List must contain Size keyword");
        assertTrue(items.contains("Price"), "List must contain Price keyword");
        assertTrue(items.contains("Quantity"), "List must contain Quantity keyword");
        assertTrue(items.contains("My Bag"), "List must contain My Bag keyword");

        assertEquals(priceDict.get("Subtotal"), "26,186,823 AMD", "Subtotal Price does not match");
        assertEquals(priceDict.get("Express Shipping to Armenia"), "10,469 AMD", "Express Price does not match");
        assertEquals(priceDict.get("Total"), "26,197,292 AMD", "Total Price does not match");

        // Adding another item to the cart and check for the prices
        addToCart.goBackToMainPage();
        addToCart.addItem2();
        addToCart.goToCart();
        List<String> items2 = addToCart.getCartItems();
        Hashtable<String, String> priceDict2 = addToCart.getTotalPrice();

        // Previously added Item must exist as well
        assertTrue(items2.contains("this is item 1 by new brand"), "List must contain the item specified");
        assertTrue(items2.contains("26,186,823 AMD"), "List must contain the price of the item specified");
        assertTrue(items2.contains("European 56 M"), "List must contain the size of the item specified");
        assertTrue(items2.contains("this-is-item-2-by-new-brand by new brand"), "List must contain the item specified");
        assertTrue(items2.contains("21,473 AMD"), "List must contain the price of the item specified");
        assertTrue(items2.contains("European 66 M"), "List must contain the size of the item specified");

        assertEquals(priceDict2.get("Subtotal"), "26,208,296 AMD", "Subtotal Price does not match");
        assertEquals(priceDict2.get("Express Shipping to Armenia"), "10,469 AMD", "Express Price does not match");
        assertEquals(priceDict2.get("Total"), "26,218,766 AMD", "Total Price does not match");
    }

}
