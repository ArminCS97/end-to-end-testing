package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private WebDriver driver;
    private WebElement searchBar;
    private final By searchBarInputLocator = By.xpath("//body/div[@id='root']/nav[1]/div[1]/div[1]/ul[2]/li[1]/div[1]/input[1]");
    private final By resultsLocator = By.xpath("//body/div[@id='root']/nav[1]/div[1]/div[1]/ul[2]/li[1]/div[1]/div[1]");

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    public void setKeyword (String keyword) {
        this.searchBar = driver.findElement(searchBarInputLocator);
        searchBar.sendKeys(keyword);
    }

    public boolean isResultDisplayed(){
        return searchBar.isDisplayed();
    }

    public List getResultsTest() {
        var resultsIcon = driver.findElement(resultsLocator);
        // All the results are of type links meaning 'a'
        var results = resultsIcon.findElements(By.tagName("a"));
        List resultTexts = new ArrayList();
        for (WebElement result : results) {
            resultTexts.add(result.getText());
        }
        return resultTexts;
    }

    public List getResultParts() {
        var resultsIcon = driver.findElement(resultsLocator);
        List resultTexts = new ArrayList();
        for (String text: resultsIcon.getText().split("\n")) {
            resultTexts.add(text);
        }
        return resultTexts;
    }
}