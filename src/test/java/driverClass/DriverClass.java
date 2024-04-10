package driverClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	public static WebDriver driver;

	public WebDriver getdriverDetails() {

		if (BrowserType.CHROME != null) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\Devas\\eclipse-2018-workspace\\DemoBlaze\\drivers");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("From driverClass " + driver);
			return driver;
		} else {
			if (BrowserType.IE != null) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return driver;
			} else {
				if (BrowserType.EDGE != null) {
					WebDriverManager.edgedriver().setup();
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					return driver;
				}
			}

		}
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}

}
