package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class CreateAccountPage {

	WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Accounts']")
	public WebElement moveAccounts;
	
	@FindBy(xpath = "//ul[@class='open']//a[text()='Create Account']")
	public WebElement createAccount;
	
	@FindBy(xpath = "//input[@title='Name']")
	public WebElement name;
	
	@FindBy(xpath = "//input[@title='Email']")
	public WebElement email;
	
	@FindBy(xpath = "//select[@title='Lead Type']")
	public WebElement drop1;
	
	@FindBy(xpath = "//select[@title='Lead Source']")
	public WebElement drop2;
	
	@FindBy(xpath = "//select[@title='Lead Status']")
	public WebElement drop3;
	
	@FindBy(xpath = "//select[@title='Deal Status']")
	public WebElement drop4;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath = "//h2[text()=' ChetankumarGangavane']")
	public static WebElement heading;
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	public void moveToAccountsMenu() {
		
		DriverUtility.moveHoverElement(moveAccounts);
	}
	public void clickOnCreateAccount() {
		DriverUtility.click(createAccount);
	}
	public void getTitleOfCreateAccountPage() {
		name.getText();
	}
	public void enterName(String Name) {
		DriverUtility.sendKeys(name, Name);
	}
	public void enterEmail(String mail) {
		DriverUtility.sendKeys(email, mail);
	}
	public void selectLeadType(String leadType) throws Exception {
		DriverUtility.selectDropDown(drop1,leadType);
	}
	public void selectLeadSource(String leadSource) throws Exception {
		DriverUtility.selectDropDown(drop2,leadSource);
	}
	public void selectLeadStatus(String leadStatus) throws Exception {
		DriverUtility.selectDropDown(drop3,leadStatus);
	}
	public void selectDealStatus(String dealStatus) throws Exception {
		DriverUtility.selectDropDown(drop4,dealStatus);
	}
	public void clickOnCreate() {
		DriverUtility.click(submit);
	}
	public static void verifyHeading() {
		heading.getText();
	}
}
