package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewAddressPage {
    private WebDriver driver;
    private Select country;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        // country = new Select(driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select"))); //? Dlaczego to jest w konstruktorze?
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    private WebElement countryList;

    @FindBy(name = "id_country")
    private WebElement country1;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;


    public void completeRequiredFields(String alias, String address, String city, String postcode, String phone) {
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postcodeInput.sendKeys(postcode);
        phoneInput.sendKeys(phone);
    }

    public void selectCountry(String countryName) {
        country = new Select(driver.findElement(By.name("id_country")));
        country.selectByVisibleText(countryName);
    }

    public void saveNewAddress() {
        //    ((JavascriptExecutor) driver).executeScript("document.getElementsByName('submitAddress').style.display='block';");
        saveButton.click();
    }

}
