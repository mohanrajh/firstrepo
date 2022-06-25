package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMsd {
	WebDriver driver;
	@Given("I load the {string}")
	public void i_load_the_sample(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverManager.chromedriver().setup();
	   driver=  new ChromeDriver();
		driver.get(url);
	}

	@Then("I enter {string} into the element {string}")
	public void i_enter_into_the_element(String input, String locator) {
	    // Write code here that turns the phrase above into concrete actions
	  driver.findElement(By.xpath(locator)).sendKeys(input); 
	}

	@Then("I click the element {string}")
	public void i_click_the_element(String locator) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(locator)).click(); 
		int i=1/0;
	}

	
	@AfterStep
	public void screnshot(Scenario s){
		s.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png", "image");
		//s.attach((, "image/png", "image");
	}
	
//	 <classificationDirectory>${project.build.directory}/classifications</classificationDirectory>
//     <classificationFiles>
//             <!-- supports wildcard or name pattern -->
//             <param>sample.properties</param>
//             <param>other.properties</param>
//     </classificationFiles>
	
}
