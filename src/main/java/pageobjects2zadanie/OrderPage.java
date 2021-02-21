package pageobjects2zadanie;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (name ="confirm-addresses")
    private WebElement confirmAddressButton;

    @FindBy (name="confirmDeliveryOption")
    private WebElement confirmShippingMethodButton;

    @FindBy (className="radio-block")
    List<WebElement> addressDeliveryRadioButtons;

    @FindBy (xpath = "//input[contains(@name,'delivery_option')]")
    List<WebElement> deliveryMethodRadioButtons;

    @FindBy (name="payment-option")
    List<WebElement> paymentMethodRadioButtons;

    @FindBy (id="conditions_to_approve[terms-and-conditions]")
    WebElement termsOfServiceAgreementCheckbox;

    @FindBy (xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement orderWithAnObligationToPayButton;


    public void submitAddress(int addressDeliveryRadioButtonNumber){
        addressDeliveryRadioButtons.get(addressDeliveryRadioButtonNumber).click(); //TODO: zmienić, żeby też był executor i zmienić FindBy name żeby było zamiast xpath
        confirmAddressButton.click();
    }


    public void submitShippingMethod(int deliveryMethodRadioButtonNumber){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", deliveryMethodRadioButtons.get(deliveryMethodRadioButtonNumber));
        confirmShippingMethodButton.click();
    }


    public void submitPaymentMethodAndOrderWithAnObligationToPay(int paymentMethodRadioButtonNumber){
        paymentMethodRadioButtons.get(paymentMethodRadioButtonNumber).click();
        termsOfServiceAgreementCheckbox.click();
        orderWithAnObligationToPayButton.click();
    }



}
