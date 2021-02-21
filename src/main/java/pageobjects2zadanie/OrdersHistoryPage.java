package pageobjects2zadanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrdersHistoryPage {
    private WebDriver driver;

    public OrdersHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"content\"]/table/tbody/tr[1]/th")
    private WebElement lastOrderReference;

    @FindBy (xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")
    private WebElement lastOrderTotalPrice;

    @FindBy (xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[4]/span")
    private WebElement lastOrderPaymentStatus;


    public String getLastOrderReference(){
        String lastOrderReferenceString = lastOrderReference.getText();
        return lastOrderReferenceString;
    }

    public String getLastOrderTotalPrice(){
        String lastOrderTotalPriceString = lastOrderTotalPrice.getText();
        return lastOrderTotalPriceString;
    }

    public String getLastOrderPaymentStatus(){
        String lastOrderPaymentStatusString = lastOrderPaymentStatus.getText();
        return lastOrderPaymentStatusString;
    }


}
