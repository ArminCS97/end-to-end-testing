package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCart {
    private WebDriver driver;

    private final By addToCartButton = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]");
    private final By cart = By.xpath("//body/div[@id='root']/nav[1]/div[1]/div[1]/ul[2]/li[3]/a[1]/div[1]/img[1]");

    // We have to be the cart page so that these 2 locators can be found
    private final By cartResults = By.tagName("div");
    private final By priceAndShippingDetails = By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]");

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void addItem1() {
        Item item = new Item(
                driver,
                "this-is-item-1-by-new-brand",
                By.xpath("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]"),
                By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"),
                By.xpath("//div[contains(text(),'56')]")
        );
        item.buy();
        // Clicking add-to-cart Button
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void addItem2() {
        Item item = new Item(
                driver,
                "this-is-item-2-by-new-brand-by-new-brand-2",
                By.xpath("//body/div[@id='root']/nav[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]"),
                By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]"),
                By.xpath("//div[contains(text(),'66')]")
        );
        item.buy();
        // Clicking add-to-cart Button
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void goToCart() {
        driver.navigate().to("https://dev00.lemonadefashion.com/cart");
        driver.findElement(cart).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goBackToMainPage () {
        // After going to cart we navigate back to the main website
        driver.navigate().to("https://dev00.lemonadefashion.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public List<String> getCartItems() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement result = driver.findElement(cartResults);
        ArrayList<String> items = new ArrayList<>();
        for (String text : result.getText().split("\n")) {
            items.add(text);
        }
        System.out.println(items + "jjjjj");
        return items;
    }

    public Hashtable<String, String> getTotalPrice() {
        WebElement result = driver.findElement(priceAndShippingDetails);
        ArrayList<String> texts = new ArrayList<>();
        for (String text : result.getText().split("\n")) texts.add(text);

        Hashtable<String, String> priceDict = new Hashtable();

        for (int i = 0; i < texts.size(); i++) {
            switch (texts.get(i)) {
                case "Subtotal":
                    priceDict.put("Subtotal", texts.get(i + 1));
                case "Express Shipping to Armenia":
                    priceDict.put("Express Shipping to Armenia", texts.get(i + 1));
                case "Total":
                    priceDict.put("Total", texts.get(i + 1));
            }
        }
        System.out.println(priceDict);
        return priceDict;
    }
}

class Item {
    private WebDriver driver;

    private String boughtItemName;
    private By menuLocator;
    private By boughtItemLocator;
    private By sizeChosenLocator;

    public Item(WebDriver driver, String boughtItemName, By menuLocator, By boughtItemLocator, By sizeChosenLocator) {
        this.driver = driver;
        this.boughtItemLocator = boughtItemLocator;
        this.sizeChosenLocator = sizeChosenLocator;
        this.menuLocator = menuLocator;
        this.boughtItemName = boughtItemName;
    }

    public void buy() {
        // Clicking the menu.
        driver.findElement(menuLocator).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Clicking on that specific item we want to buy.
        driver.findElement(boughtItemLocator).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://dev00.lemonadefashion.com/shopping/" + boughtItemName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Selecting size for it
        driver.findElement(sizeChosenLocator).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
