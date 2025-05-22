package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTests extends BaseTest{

	public static WebDriver driver = null;
	public static LoginPage loginPage = null;
	
	
	@Given("user is in the login page")
	public void user_is_in_the_login_page() {		
		
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		loginPage = new LoginPage(driver);
				
		driver.get("https://devapp.valianttinfo.com/");
		
	}

	@Then("user can able to see the input elements and submit button")
	public void user_can_able_to_see_the_input_elements_and_submit_button() {
		
		Assert.assertEquals(loginPage.username_Inp.isDisplayed(), true);
		Assert.assertEquals(loginPage.password_Inp.isDisplayed(), true);
		Assert.assertEquals(loginPage.login_Btn.isDisplayed(), true);
			
	}
	
	@And("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		
		loginPage.enterUsernameAndPassword(username, password);
		
	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    
		loginPage.clickLoginBtn();
		
	}

	@Then("user can able to see the dashboard page")
	public void user_can_able_to_see_the_dashboard_page() throws InterruptedException {

		Thread.sleep(Duration.ofSeconds(1));
		Assert.assertEquals(driver.getCurrentUrl(), "https://devapp.valianttinfo.com/company/dashboard");
		
	}

	@Then("user should see a error prompt or alert")
	public void user_should_see_a_error_prompt_or_alert() {
	    
		Assert.assertEquals(loginPage.errorMessage.getText(), "username is not registered");
		loginPage.clickErrorDoneBtn();
		
	}
	
}