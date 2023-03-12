package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {

    public WebElement getPageTitle() {
        return pageTitle;
    }

    @FindBy(xpath = "//div[@class='book-item']")
    private List<WebElement> searchResults;

    private WebElement pageTitle = driver.findElement(By.xpath("//*[contains(text(),'Search results for')]"));
    private WebElement priceRange = driver.findElement(By.id("filterPrice"));
    private WebElement highPrice = driver.findElement(By.xpath("//*[contains(text(),'30 € +')]"));
    private WebElement availability = driver.findElement(By.id("filterAvailability"));
    private WebElement inStock = driver.findElement(By.xpath("//*[contains(text(),'In Stock')]"));
    private WebElement language = driver.findElement(By.id("filterLang"));
    private WebElement englishLang = driver.findElement(By.xpath("//*[contains(text(),'English (')]"));
    private WebElement format = driver.findElement(By.id("filterFormat"));
    private WebElement paperbackFormat = driver.findElement(By.xpath("//*[contains(text(),'Paperback (')]"));
    private WebElement refineResultsButton = driver.findElement(By.xpath("//*[contains(text(),'Refine results')]"));

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        List<WebElement> neededElements = driver.findElements(By.cssSelector(".book-item h3 a"));
        return neededElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public FilteredSearchPage filterItems() {
        priceRange.click();
        highPrice.click();
        availability.click();
        inStock.click();
        language.click();
        englishLang.click();
        format.click();
        paperbackFormat.click();
        refineResultsButton.click();
        return new FilteredSearchPage(driver);
    }
}
