package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOrderPage extends BasePage {
    private WebElement deliveryCountrySpan = driver.findElement(By.xpath("//span[@name='deliveryCountry']"));

    public CheckoutOrderPage(WebDriver driver) {
        super(driver);
    }

    public CountryDropdownPage openDeliveryCountrySpan() {
        deliveryCountrySpan.click();
        return new CountryDropdownPage(driver);
    }
}
