package bookdepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetailPage extends BasePage {
    public WebElement getNameField() {
        return nameField;
    }

    private WebElement nameField = driver.findElement(By.id("delivery-fullName"));

    public WebElement getAddressLineField1() {
        return addressLineField1;
    }

    private WebElement addressLineField1 = driver.findElement(By.id("delivery-addressLine1"));

    public WebElement getAddressLineField2() {
        return addressLineField2;
    }

    private WebElement addressLineField2 = driver.findElement(By.id("delivery-addressLine2"));

    public WebElement getCityField() {
        return cityField;
    }

    private WebElement cityField = driver.findElement(By.id("delivery-city"));

    public WebElement getCountyField() {
        return countyField;
    }

    private WebElement countyField = driver.findElement(By.id("delivery-county"));

    public WebElement getPostcodeField() {
        return postcodeField;
    }

    private WebElement postcodeField = driver.findElement(By.id("delivery-postCode"));
    private WebElement frameCardNum = driver.findElement(By.xpath("//iframe[@id='braintree-hosted-field-number']"));
    private WebElement frameExpDate = driver.findElement(By.xpath("//div/iframe[@id='braintree-hosted-field-expirationDate']"));
    private WebElement frameCvv = driver.findElement(By.xpath("//div/iframe[@id='braintree-hosted-field-cvv']"));

    public OrderDetailPage(WebDriver driver) {
        super(driver);
    }

    void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void inputTextIntoFields(By locator, String data) {
        WebElement inputTextIntoField = driver.findElement(locator);
        inputTextIntoField.sendKeys(data);
    }

    public void fillCardNumField(String cardNumber) {
        driver.switchTo().frame(frameCardNum);
        inputTextIntoFields(By.xpath("//input[@id='credit-card-number']"), cardNumber);
        switchToDefault();
    }

    public void fillCvvField(String cvv) {
        driver.switchTo().frame(frameCvv);
        inputTextIntoFields(By.xpath("//input[@id='cvv']"), cvv);
        switchToDefault();
    }

    public void fillExpirationField(String expDate) {
        driver.switchTo().frame(frameExpDate);
        inputTextIntoFields(By.id("expiration"), expDate);
        switchToDefault();
    }
}
