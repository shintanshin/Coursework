package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {
    public WebElement getPageTitle() {
        return pageTitle;
    }

    private WebElement pageTitle = driver.findElement(By.xpath("//*[text()='Your basket']"));
    private WebElement checkoutButton = driver.findElement(By.xpath("//div/a[1][text()='Checkout']"));

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getDeliveryCost() {
        WebElement deliveryCostElement = driver.findElement(By.xpath("//dt[contains(text(), 'Delivery cost')]/following-sibling::dd"));
        return deliveryCostElement.getText().trim();
    }
    public String getTotal() {
        WebElement totalElement = driver.findElement(By.xpath("//*[contains(text(), 'Total')]/following-sibling::dd"));
        return totalElement.getText().trim();
    }

    public OrderPage goToPaymentDetailPage() {
        checkoutButton.click();
        return new OrderPage(driver);
    }
}
