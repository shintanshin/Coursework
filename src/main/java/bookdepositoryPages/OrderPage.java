package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {
    private WebElement emailField = driver.findElement(By.xpath("//*[@name='emailAddress']"));
    private WebElement phoneCode = driver.findElement(By.xpath("//*[@name='delivery-telephone-prefix']"));
    private WebElement phoneCodePL = driver.findElement(By.xpath("//*[text()='UA +380']"));
    private WebElement phoneField = driver.findElement(By.xpath("//*[@name='delivery-telephone']"));
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    public String getSubTotal() {
        WebElement deliveryCostElement = driver.findElement(By.xpath("//*[contains(text(),'Sub-total')]//ancestor::dt//following-sibling::dd"));
        return deliveryCostElement.getText().trim();
    }
    public String getDeliverySum() {
        WebElement deliveryCostElement = driver.findElement(By.xpath("//*[contains(text(), 'Delivery')]//ancestor::dt//following-sibling::dd"));
        return deliveryCostElement.getText().trim();
    }
    public String getTotalSum() {
        WebElement deliveryCostElement = driver.findElement(By.xpath("//*[contains(text(), 'Total')]//ancestor::dt//following-sibling::dd"));
        return deliveryCostElement.getText().trim();
    }
    public CheckoutOrderPage checkoutWithEmail(String email, String phone) {
        emailField.sendKeys(email);
        phoneCode.click();
        phoneCodePL.click();
        phoneField.sendKeys(phone);
        return new CheckoutOrderPage(driver);
    }
}
