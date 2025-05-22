package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {
	
	public static WebDriver driver = null;
	public static LoginPage loginPage = null;
	
	@BeforeMethod
	public void setUp() {

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		loginPage = new LoginPage(driver);

	}
	
	@AfterMethod
	public void tearDown() {
		
	}
	
	public static void waitFor(WebDriver driver, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(webDriver -> true);
	}
	
}
