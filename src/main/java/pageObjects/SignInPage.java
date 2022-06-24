package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "LoginForm_username")
	public WebElement textUsername;
	
	@FindBy(id = "LoginForm_password")
	public WebElement textPass;
	
	@FindBy(id = "LoginForm_rememberMe")
	public WebElement checked;
	
	@FindBy(xpath = "//button")
	public WebElement btnSignin;
	
	public void setUserName(String uname) {
		DriverUtility.sendKeys(textUsername,uname);
	}
	public void setPassword(String pwd) {
		DriverUtility.sendKeys(textPass,pwd);
	}
	public void clickCheck() {
		DriverUtility.click(checked);
	}
	public void clickSignin() throws Exception {
		DriverUtility.doubleClick(btnSignin);
		Thread.sleep(2000);
		DriverUtility.doubleClick(btnSignin);
	}
}
