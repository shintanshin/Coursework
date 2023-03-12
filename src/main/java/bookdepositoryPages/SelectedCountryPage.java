package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedCountryPage extends BasePage {
    private WebElement fillAddressButton = driver.findElement(By.xpath("//*[@id='delivery-manualEntryDeliveryAddress']"));

    public SelectedCountryPage(WebDriver driver) {
        super(driver);
    }

    public OrderDetailPage openAddressFields() {
        fillAddressButton.click();
        return new OrderDetailPage(driver);
    }
}
