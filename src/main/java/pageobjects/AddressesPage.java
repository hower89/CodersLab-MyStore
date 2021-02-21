package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.apache.commons.lang3.StringUtils;

public class AddressesPage {
    WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement createNewAddressButton;

    // zwrócić uwagę, że chcąc wybrać last muszę wrzucić w nawias całe wyrażenie przed lastem

    @FindBy(xpath = "(//a[@data-link-action='delete-address'])[last()]")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/aside/div/article") //TODO poprawić/zamienić
    private WebElement alert;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement successMessage;

    @FindBy(xpath = "(//h4)[last()]")
    private WebElement alias;

    @FindBy(xpath = "(//address)[last()]")
    private WebElement addressBox;

    @FindBy(xpath = "(//article)[last()]/div[1]/address/text()[2]")
    private WebElement address;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement userAccountLink;


    public void createNewAddress() {
        createNewAddressButton.click();
    }

    public void verifySuccessMessage() {
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals("Address successfully added!", successMessage.getText());
    }

    public void verifyAlias(String aliasText) {
        Assert.assertTrue(alias.isDisplayed());
        Assert.assertEquals(aliasText, alias.getText());
    }

    public void printDataTable() {
        final String dataTableText = addressBox.getText();
        System.out.println(dataTableText);

    }

    public void printAddress() {
        final String addressText = address.getText();
        System.out.println(addressText);
    }

    public void verifyAddressBoxData(String addressBoxText) {

        Assert.assertTrue(addressBox.isDisplayed());
        Assert.assertEquals(addressBoxText, addressBox.getText());

    }

    public String getNewAddressDataText() {
        String addressBoxText = addressBox.getText();
        String userName = userAccountLink.getText();
        String newAddressText = StringUtils.substringAfter(addressBoxText, userName); // w AddressBox mamy dane adresowe z imieniem i nazwiskiem, które wskakuje samo przy zakładaniu nowego adresu, a mamy sprawdzić tylko nowo wprowadzone dane (alias, address, city, postcode, phone)
        return newAddressText;
    }

    public void deleteLastAddress_thenValidateDeletion() {
        deleteAddressButton.click();
        Assert.assertTrue(alert.isDisplayed());
        Assert.assertEquals("Address successfully deleted!", alert.getText());
    }


    public String getAlias() {
        return alias.getText();
    }

    public String getAddressBox() {
        return addressBox.getText();
    }

}

