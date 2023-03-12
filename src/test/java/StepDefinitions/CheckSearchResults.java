package StepDefinitions;

import bookdepositoryPages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CheckSearchResults {

    WebDriver driver;

    @Given("I am an anonymous customer with the clear cookies")
    public void clearCookies() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("I open the \"Initial home page\"")
    public void openInitialHomePage() {
        driver.get("https://www.bookdepository.com/");
    }

    @And("I search for \"Thinking in Java\"")
    public void searchForBook() {
        InitialHomePage initialHomePage = new InitialHomePage(driver);
        initialHomePage.searchItems("Thinking in Java");
    }

    @And("I am redirected to a \"Search page\"")
    public void redirectToSearchPage() {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.getPageTitle().isDisplayed());
    }

    @And("Search results contain the following products")
    public void searchResultsContainProducts(List<String> expectedProducts) {
        SearchPage searchPage = new SearchPage(driver);
        List<String> searchActualProducts = searchPage.getProductNames();
        Assert.assertTrue(searchActualProducts.contains("Thinking in Java"));
        Assert.assertTrue(searchActualProducts.contains("Thinking Java Part I"));
        Assert.assertTrue(searchActualProducts.contains("Core Java Professional"));
    }

    @And("I apply the following search filters")
    public void applyFollowingFilters(Map<String, String> filters) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.filterItems();
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnly(List<String> expectedProducts) {
        SearchPage searchPage = new SearchPage(driver);
        List<String> searchActualProducts = searchPage.getProductNames();
        Assertions.assertEquals(expectedProducts, searchActualProducts, "Search results do not contain the expected products");
    }

    @And("I click \"Add to basket button for product with name \"Thinking in Java\"")
    public void clickToAddToBasket() {
        FilteredSearchPage filteredSearchPage = new FilteredSearchPage(driver);
        filteredSearchPage.addToBasket();
    }

    @And("I select 'Basket Checkout in basket pop-up")
    public void selectBasketCheckout() {
        PopUpBasketPage popUpBasketPage = new PopUpBasketPage(driver);
        popUpBasketPage.goToBasket();
    }

    @And("I am redirected to a \"Basket page\"")
    public void redirectToBasketPge() {
        BasketPage basketPage = new BasketPage(driver);
        Assert.assertTrue(basketPage.getPageTitle().isDisplayed());
    }

    @And("Basket order summary is as following:")
    public void basketSummaryAsFollowing(DataTable dataTable) {
        BasketPage basketPage = new BasketPage(driver);
        Map<String, String> orderSummary = dataTable.asMap(String.class, String.class);
        String expectedDeliveryCost = orderSummary.get("Delivery cost");
        String expectedTotal = orderSummary.get("Total");
        String actualDeliveryCost = basketPage.getDeliveryCost();
        String actualTotal = basketPage.getTotal();
        Assert.assertEquals(expectedDeliveryCost, actualDeliveryCost);
        Assert.assertEquals(expectedTotal, actualTotal);
    }

    @And("I click 'Checkout' button on 'Basket' page")
    public void clickCheckoutButton() {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.goToPaymentDetailPage();
    }

    @And("I checkout as a new customer with email \"test@mail.com\"")
    public void checkoutWithEmail() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.checkoutWithEmail("test@mail.com", "989000009");
    }

    @And("Checkout order summary is as following:")
    public void checkoutSummaryAsFollowing(DataTable expectedOrderSummary) {
        OrderPage orderPage = new OrderPage(driver);
        Map<String, String> orderSummary = expectedOrderSummary.asMap(String.class, String.class);
        String expectedSubTotal = orderSummary.get("SubTotal");
        String expectedDelivery = orderSummary.get("Delivery");
        String expectedTotalSum = orderSummary.get("Total");
        String actualSubTotal = orderPage.getSubTotal();
        String actualDelivery = orderPage.getDeliverySum();
        String actualTotalSum  = orderPage.getTotalSum();
        Assert.assertEquals(expectedSubTotal, actualSubTotal);
        Assert.assertEquals(expectedDelivery, actualDelivery);
        Assert.assertEquals(expectedTotalSum, actualTotalSum);
    }

    @When("I fill delivery address information manually:")
    public void fillAddressInfo(DataTable expectedOrderSummary) throws InterruptedException {
        CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage(driver);
        CountryDropdownPage countryDropdownPage = new CountryDropdownPage(driver);
        checkoutOrderPage.openDeliveryCountrySpan();
        countryDropdownPage.selectCountry();
        OrderDetailPage orderDetailPage = new OrderDetailPage(driver);
        orderDetailPage.getNameField().sendKeys("Anna");
        orderDetailPage.getAddressLineField1().sendKeys("Random address 1 ");
        orderDetailPage.getAddressLineField2().sendKeys("Random address 2 ");
        orderDetailPage.getCityField().sendKeys("Kyiv");
        orderDetailPage.getCountyField().sendKeys("Random State");
        orderDetailPage.getPostcodeField().sendKeys("123");
    }

    @And("I enter my card details")
   public void fillCreditCardDetails(Map<String, String> details) {
        OrderDetailPage orderDetailPage = new OrderDetailPage(driver);
        orderDetailPage.fillCardNumField("4111 1111 1111 1111");
        orderDetailPage.fillExpirationField("03/2025");
        orderDetailPage.fillCvvField("123");
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
