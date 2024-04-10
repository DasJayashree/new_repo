package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupPage {
	WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_username = By.xpath("//input[@id='sign-username']");
	By txt_password = By.xpath("//input[@id='sign-password']");
	By btn_signupUser = By.xpath(
			"//div[@id='signInModal']//div[@class='modal-content']//div[@class='modal-footer']//button[@class='btn btn-primary']");
	
	By link_signup = By.cssSelector("a[id='signin2']");
	By signupModal = By.xpath("//div[@id='signInModal']");

	public void usernameField() {
		driver.findElement(txt_username);
	}

	public void passworField() {
		driver.findElement(txt_password);
	}

	public void signupButton() {
		driver.findElement(btn_signupUser);
	}

	public void signupLinkClick() {
		driver.findElement(link_signup).click();

	}

	public void signupUser(String username, String password) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait for the modal box be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(signupModal));
		// fetch the web element of the modal container
		System.out.println("Fetching the web element for modal container");
		WebElement modalContainer = driver.findElement(signupModal);

		System.out.println("Clicking modal accept button");
		WebElement modalSignuptButton = modalContainer.findElement(By.xpath(".//button[@class='btn btn-primary']"));

		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// click on accept modal button
		modalSignuptButton.click();	

		wait.until(ExpectedConditions.alertIsPresent());
		String actualMessage = null;
		String expectedMessage = null;
		Alert sighupAlert = driver.switchTo().alert();
		try {
			
			actualMessage = sighupAlert.getText();
			if (sighupAlert.getText().contains("Sign up successful.")) {
				expectedMessage = "Sign up successful.";
				System.out.println("Signup Done");
			} else {
				expectedMessage = "This user already exist.";
				System.out.println("User already exist");
			}

		} catch (Exception e) {
			expectedMessage = "This user already exist.";
			System.out.println("Error : User already exist");
		}

		Assert.assertEquals(expectedMessage, actualMessage);
		//sighupAlert.accept();
	}

	public void checkElementsPresent() {

		assertTrue(isElementPresent(txt_username));
		assertTrue(isElementPresent(txt_password));
		assertTrue(isElementPresent(btn_signupUser));

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
