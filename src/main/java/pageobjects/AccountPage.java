package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id="addresses-link")
    private WebElement addressesButton;

    @FindBy (id="history-link")
    private WebElement orderHistoryButton;

    public void goToAddresses(){
        addressesButton.click();
    }

    public void goToOrdersHistory(){
        orderHistoryButton.click();
    }

}
