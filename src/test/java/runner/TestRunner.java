package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import driverClass.DriverClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinations" }, plugin = {
		"html:target/cucumber/html_report.html", "pretty" })
public class TestRunner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	DriverClass dr = new DriverClass();
    
	@BeforeSuite		
	public WebDriver getdriverDetails() {
		driver = dr.getdriverDetails();
		return driver;
	}
	@AfterSuite
	public void tearDown() {
		dr.closeDriver();
	}

}
