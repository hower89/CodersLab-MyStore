package pageobjects2zadanie;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HummingbirdSweaterPage {

    private WebDriver driver;
    private Select sizeDropdown;

    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    private WebElement discountValueInfo;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement discountPrice;

    @FindBy(className = "regular-price")
    private WebElement regularPrice;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    public HummingbirdSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateDiscount(String expectedDiscountInfo) {
        //sprawdzanie czy napis o zniżce zgadza się z oczekiwanym (napis określamy w głównej klasie z testem)
        String discountValueText = discountValueInfo.getText();
        Assert.assertTrue(discountValueInfo.isDisplayed());
        Assert.assertEquals(expectedDiscountInfo, discountValueText);
        //zamiana Stringa ceny promocyjnej na Double z ceną promocyjną
        Assert.assertTrue(discountPrice.isDisplayed());
        String discountPriceString = discountPrice.getText();
        String discountPriceValueString = discountPriceString.substring(discountPriceString.length()-5); //ostatnie 5 znaków to cena, np. 21.95 //TODO jednak nie działa, bo może być 135 euro
        Double discountPriceValueDouble = Double.valueOf(discountPriceValueString);
        //zamiana Stringa ceny nominalnej na Double z ceną nominalną
        Assert.assertTrue(regularPrice.isDisplayed());
        String regularPriceString = regularPrice.getText();
        String regularPriceValueString = regularPriceString.substring(regularPriceString.length()-5);
        Double regularPriceValueDouble = Double.valueOf(regularPriceValueString);
        //sprawdzenie, czy promocja na pewno wynosi 20%
        Double calculatedDiscountValue = regularPriceValueDouble*0.8;
        Assert.assertEquals(calculatedDiscountValue, discountPriceValueDouble);
    }


    /*Select specific size
    public void selectSize(String size) {
        sizeDropdown = new Select(driver.findElement(By.id("group_1")));
        sizeDropdown.selectByVisibleText(size);
    }

     */

    public void selectRandomSize() {
        List<String> sizesList = Arrays.asList("S", "M", "L", "XL");
        Random rnd = new Random();
        String randomSize = sizesList.get(rnd.nextInt(sizesList.size()));
        sizeDropdown = new Select(driver.findElement(By.id("group_1")));
        sizeDropdown.selectByVisibleText(randomSize);
    }


/*Select specific quantity
    public void selectQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

 */
public void selectQuantityBetween1and1000() {
    quantityInput.clear();
    Random rnd = new Random();
    int i = rnd.nextInt(1000) + 1;
    quantityInput.sendKeys(String.valueOf(i));
}

    public void addToCart() {
        addToCartButton.click();
    }

    public void proceedToCheckoutInPopupWindow() {
        proceedToCheckoutButton.click();
    }

}
