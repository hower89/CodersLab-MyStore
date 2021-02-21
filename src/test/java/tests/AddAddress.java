package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;


public class AddAddress {
    //1. dodajemy webdrivera
    private WebDriver driver;

    private MainPage mainPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private AddressesPage addressesPage;
    private NewAddressPage newAddressPage;

    private String login = "joszko.kurwibrzdyl@mail.com";
    private String password = "jebacpis2021";


    //2. Wrzucam kolejne kroki z gherkina i dodaję w nich metody (na razie puste, później w nich znajdą się metody z konkretnych page'y)
    @Given("the user is on the Addresses page")

    public void openAddressesPage() {
        //2a. określenie ścieżki do drivera, stworzenie nowego obiektu klasy ChromeDriver i określenie linku, który chcemy otworzyć
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        //2b. jesli nie stworzę wcześniej w klasach Page konstruktora, to nie mogę tu wrzucić drivera
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        addressesPage = new AddressesPage(driver);
        newAddressPage = new NewAddressPage(driver);

        //2c. wywołuję metody z kolejnych page'y, dzięki którym wchodzę na stronę Addresses (to jest moje "given", z którego zaczynam test)
        mainPage.goToLoginPage();
        loginPage.logIn(login, password);
        accountPage.goToAddresses();

    }

    @And("the user clicks the New address button")
    public void addNewAddress() {
        addressesPage.createNewAddress();

    }

    @When("the user completes the Alias box with (.*), Address box with (.*), City box with (.*), Zip/postal code box with (.*), Phone box with (.*)")
    public void fillUpBoxes(String alias, String address, String city, String postcode, String phone) {
        newAddressPage.completeRequiredFields(alias, address, city, postcode, phone);

    }

    @And("the user chooses a country (.*) from the list")
    public void chooseCountryFromTheList(String countryName) {
        newAddressPage.selectCountry(countryName);
    }


    @And("the user submits changes")
    public void submitChanges() {
        newAddressPage.saveNewAddress();
    }


    @When("a success message is displayed")
    public void displayMessage() {
        addressesPage.verifySuccessMessage();
    }

    @And("the data is being verified: alias (.*)")
    public void verifyAlias(String alias) {
        addressesPage.verifyAlias(alias);

    }

    @And("the data is being verified: address (.*), city (.*), postcode (.*), country (.*), phone (.*)")
    public void verifyteNewAddressData(String address, String city, String postcode, String phone, String country) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(address).append("\n").append(city).append("\n").append(postcode).append("\n").append(phone).append("\n").append(country);
        String newAddressData = sb.toString();

        // System.out.println(newAddressData);
        String newAddressDataText = addressesPage.getNewAddressDataText();
        Assert.assertEquals(newAddressData, newAddressDataText);
        System.out.println(newAddressData);
        System.out.println(newAddressDataText);
    }
    /* Wersja bez StringBuildera
    public void validateNewAddressData(String address, String city, String postcode, String phone, String country){
        String newAddressData = "\n" + address + "\n" + city + "\n" + postcode + "\n"  + phone + "\n"  + country;
        // System.out.println(newAddressData);
        String newAddressDataText = addressesPage.getNewAddressDataText();
        Assert.assertEquals(newAddressData, newAddressDataText);
    }
    */

    @Then("the user deletes newly added address; the deletion is being verified")
    public void deleteNewAddress() {
        addressesPage.deleteLastAddress_thenValidateDeletion();
    }

    @And("the browser is being closed")
    public void closeBrowser() {
        driver.quit();
        System.out.println("\nWszystko śmiga");
    }

}
