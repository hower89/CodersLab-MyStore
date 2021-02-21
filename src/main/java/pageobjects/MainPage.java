package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="_desktop_user_info")
    private WebElement signInButton;

    @FindBy(name="s")
    private WebElement searchInput;

    public void goToLoginPage() {
        signInButton.click();
    }

    public void searchHummingbird(String search){
        searchInput.clear();
        searchInput.sendKeys(search);
        searchInput.submit();
    }

}
