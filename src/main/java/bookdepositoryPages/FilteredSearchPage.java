package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilteredSearchPage extends BasePage {
    //знайти поле потрібної книги яку додати в корзину
    private WebElement addBasketButton = driver.findElement(By.xpath("//*[@href='/basket/addisbn/isbn13/9780131872486']"));
    public FilteredSearchPage(WebDriver driver) {
        super(driver);
    }
    public PopUpBasketPage addToBasket(){
        addBasketButton.click();
        return new PopUpBasketPage(driver);
    }
    public List<WebElement> getSearchResultElements() {
        return driver.findElements(By.xpath("//a[contains(text(),'%s')]"));//div[@class='book-item']/h3/a //a[contains(text(),'%s')]
    }
}
