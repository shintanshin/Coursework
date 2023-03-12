package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountryDropdownPage extends BasePage {
    private WebElement fillAddressButton = driver.findElement(By.xpath("//*[@id='delivery-manualEntryDeliveryAddress']"));

    public CountryDropdownPage(WebDriver driver) {
        super(driver);
    }

    public OrderDetailPage selectCountry() throws InterruptedException {
        driver.findElement(By.xpath("//*[@name='option-PL']")).click();
        Thread.sleep(1000);
        fillAddressButton.click();
        Thread.sleep(1000);
        return new OrderDetailPage(driver);
    }
}
