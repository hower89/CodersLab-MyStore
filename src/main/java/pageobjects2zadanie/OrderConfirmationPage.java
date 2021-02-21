package pageobjects2zadanie;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[3]//td[2]") //table row, and table data cell
    private WebElement orderValue;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement userAccountLink;

    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li[1]")
    private WebElement orderReferenceText;


    public String getOrderReferenceNumber(){
        Assert.assertTrue(orderReferenceText.isDisplayed());
        String orderReferenceString = orderReferenceText.getText();
        String orderReferenceNumber = orderReferenceString.substring(orderReferenceString.length()-9); // nr zamówienia składa się z 9 znaków, które są na końcu Stringa
        return orderReferenceNumber;
    }

    public String getOrderValue(){
        Assert.assertTrue(orderValue.isDisplayed());
        String orderValueString = orderValue.getText();
        return orderValueString;
    }

    public void screenshotFullPage() throws Exception{
        Thread.sleep(2000);
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"jpg",new File("D://Screenshots/ScreenshotFullPage.jpg"));
    }

    public void goToAccountPage() {
        userAccountLink.click();
    }


}
