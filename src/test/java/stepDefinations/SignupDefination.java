package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.SignupPage;

public class SignupDefination {
	public static WebDriver driver;
	SignupPage signup;
	
	@Given("^User is on valid webpage$")
	public void user_is_on_valid_webpage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com");

	}
	/* Navigating to Modal page of SignUp */
	@When("^User click on sign up button should redirect to sign up page$")
	public void User_click_on_sign_up_button_should_redirect_to_sign_up_page() {

		signup = new SignupPage(driver);
		signup.signupLinkClick();

	}
	/* Signing up new user */
	@And("^User enterd the valid username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enterd_the_valid_name(String usernameEntered, String passwordEntered) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		signup = new SignupPage(driver);

		signup.checkElementsPresent();
		signup.usernameField();
		signup.passworField();
		signup.signupButton();

		System.out.println(usernameEntered);
		System.out.println(passwordEntered);

		signup.signupUser(usernameEntered, passwordEntered);

		//System.out.println("Success!");
		driver.quit();
	}

}
