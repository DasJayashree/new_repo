package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_search = By.xpath("//textarea[@title='Search']");
	By btn_googleSearch = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@role='button']");

	public void textSearch() {
		driver.findElement(txt_search);
	}

	public void txtEntered(String textEnterd) {
		driver.findElement(txt_search).sendKeys(textEnterd);
	}

	public void btnSerach() {
		driver.findElement(btn_googleSearch).click();
	}

	public void validateMessage() {
		String expectedText = "Welcome to Demo_blaze";
		String actualText = driver.getTitle();
//		if (expectedText != actualText) {
//			System.out.println("There is no Welcome messgage for users.");
//		} else {
		Assert.assertEquals(actualText, expectedText);
//		}
	}

}
