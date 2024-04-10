package stepDefinations;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import runner.TestRunner;

public class HomePageDefination {
	WebDriver driver1;
	HomePage hpage;

	@Given("^The user is on  valid WebBrowser$")
	public void The_user_is_on_valid_webBrowser() {

		driver1 = TestRunner.driver;
		driver1.get("https://Google.com/");

	}
	/* Navigation to HomePage */
	@Then("^Enter the DemoBlaze Url$")
	public void Enter_the_DemoBlaze_Url() {
		hpage = new HomePage(driver1);
		hpage.textSearch();
		hpage.txtEntered("https://www.demoblaze.com/");
		hpage.btnSerach();

	}

	/* Validating message on Homepage */
	@And("^Validate that the DemoBlaze displays Welcome Greeting to the user$")
	public void Validate_that_the_site_displays_Welcome_Greeting_to_the_user() {
		driver1.get("https://www.demoblaze.com/");
		hpage.validateMessage();

	}

}
