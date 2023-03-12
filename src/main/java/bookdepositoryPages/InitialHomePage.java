package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InitialHomePage extends BasePage{
    private WebElement searchField = driver.findElement(By.name("searchTerm"));
    private WebElement searchButton = driver.findElement(By.xpath("//*[text()='Search']"));

    public InitialHomePage(WebDriver driver) {
        super(driver);
    }
    public SearchPage searchItems(String title) {
        searchField.sendKeys(title);
        searchButton.click();
        return new SearchPage(driver);
    }
}
