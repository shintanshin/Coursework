package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpBasketPage extends BasePage{
    private WebElement basketAndCheckoutButton = driver.findElement(By.xpath("//*[text()='Basket / Checkout']"));
    public PopUpBasketPage(WebDriver driver){
        super(driver);
    }
    public BasketPage goToBasket(){
        basketAndCheckoutButton.click();
        return new BasketPage(driver);
    }
}
