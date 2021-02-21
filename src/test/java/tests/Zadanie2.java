package tests;

import extratools.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;
import pageobjects2zadanie.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class Zadanie2 {
    private WebDriver driver;

    private final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver.exe";
    private final String URL = "https://prod-kurs.coderslab.pl/index.php";


    AccountPage accountPage;
    LoginPage loginPage;
    MainPage mainPage;
    Screenshot screenshot;

    CartPage cartPage;
    HummingbirdSweaterPage hummingbirdSweaterPage;
    OrderConfirmationPage orderConfirmationPage;
    OrdersHistoryPage ordersHistoryPage;
    OrderPage orderPage;
    SearchResultsPage searchResultsPage;
    private int orderReferenceFullTextLength;


    //Dane do logowania
    Random rnd = new Random();
    private String login = "joszko.kurwibrzdyl@mail.com";
    private String password = "jebacpis2021";
    private String search = "Hummingbird Printed Sweater";
    private String quantity2 = "5";
    private String size = "M";
    private String expectedDiscountText = "SAVE 20%";
    private int addressDeliveryRadioButtonNumber = 0;
    private int deliveryMethodRadioButtonNumber = 0;
    private int paymentMethodRadioButtonNumber = 0;
    private String paymentStatus = "Awaiting check payment";


    @Before
    public void prepareEnvironment() {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_PATH); // czemu duzymi
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);

        accountPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        cartPage = new CartPage(driver);
        hummingbirdSweaterPage = new HummingbirdSweaterPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        ordersHistoryPage = new OrdersHistoryPage(driver);
        orderPage = new OrderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        screenshot = new Screenshot();
    }

    @Test
    public void buySweaterAndMakeScreenshot() throws Exception {
        mainPage.goToLoginPage();
        loginPage.logIn(login, password);
        mainPage.searchHummingbird(search);

        searchResultsPage.goToHummingbirdSweaterPage();
        hummingbirdSweaterPage.validateDiscount(expectedDiscountText);
        hummingbirdSweaterPage.selectRandomSize();
        // hummingbirdSweaterPage.selectQuantity(quantity2);
        hummingbirdSweaterPage.selectQuantityBetween1and1000();
        hummingbirdSweaterPage.addToCart();
        hummingbirdSweaterPage.proceedToCheckoutInPopupWindow();

        cartPage.proceedToCheckout();

        orderPage.submitAddress(addressDeliveryRadioButtonNumber);
        orderPage.submitShippingMethod(deliveryMethodRadioButtonNumber);
        orderPage.submitPaymentMethodAndOrderWithAnObligationToPay(paymentMethodRadioButtonNumber);
        screenshot.screenshotCurrentView();

        orderConfirmationPage.screenshotFullPage();

        //dodatkowe kroki - sprawdzić, czy ostatnie zamówienie jest na liście i czy ma odpowiednią cenę, i status "Awaiting check payment"
        String orderReferenceNumberFromConfirmationPage = orderConfirmationPage.getOrderReferenceNumber();
        String orderValueFromOrderConfirmationPage = orderConfirmationPage.getOrderValue();
        orderConfirmationPage.goToAccountPage();
        accountPage.goToOrdersHistory();
        String lastOrderReferenceNumber = ordersHistoryPage.getLastOrderReference();
        String lastOrderValue = ordersHistoryPage.getLastOrderTotalPrice();
        String lastOrderPaymentStatus = ordersHistoryPage.getLastOrderPaymentStatus();

        Assert.assertEquals(orderReferenceNumberFromConfirmationPage, lastOrderReferenceNumber);
        Assert.assertEquals(orderValueFromOrderConfirmationPage, lastOrderValue);
        Assert.assertEquals(paymentStatus, lastOrderPaymentStatus);
    }

    @After
    public void closeBrowser(){
        driver.quit();
        System.out.println("Wszystko śmiga");
    }
}