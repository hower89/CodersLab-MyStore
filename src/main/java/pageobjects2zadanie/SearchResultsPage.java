package pageobjects2zadanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath="//img[@alt='Brown bear printed sweater']") //TODO Uwaga! Dziwne nazwa (brown bear zamiast hummingbird)
    private WebElement hummingbirdSweater;

    public void goToHummingbirdSweaterPage(){
        hummingbirdSweater.click();
    }


}
