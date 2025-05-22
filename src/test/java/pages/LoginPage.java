package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[name='useremail']")
	public WebElement username_Inp;
	
	@FindBy(css = "[placeholder='Enter password']")
	public WebElement password_Inp;
	
	@FindBy(xpath = "//*[text() = 'Log In']")
	public WebElement login_Btn;
	
	@FindBy(css = "article span")
	public WebElement errorMessage;
	
	@FindBy(css = "article button")
	public WebElement errorDone_btn;
	
	public void enterUsernameAndPassword(String username, String password) {
		username_Inp.sendKeys(username);
		password_Inp.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		login_Btn.click();
	}
	
	public void clickErrorDoneBtn() {
		errorDone_btn.click();
	}
	
}
