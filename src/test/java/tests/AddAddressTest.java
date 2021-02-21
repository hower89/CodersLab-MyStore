package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/add-new-address.feature",
        plugin = {"pretty", "html:out"})

public class AddAddressTest {
}
