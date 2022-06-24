package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class AllAccountsPage {

	WebDriver driver;

	public AllAccountsPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Accounts']")
	public WebElement moveAccounts;
	
	@FindBy(xpath = "//ul[@class='open']//a[text()='All Accounts']")
	public WebElement allAccounts;
	
	@FindBy(xpath = "//a[@title='Columns']")
	public WebElement columnIcon;
	
	@FindBy(xpath = "//li/input[@type='checkbox']")
	public List <WebElement> checkboxes;
	
	@FindBy(xpath = "//a[(text()='Address 2') or (text()='Description')] ")
	public List <WebElement> columns;
	
	public void moveToAccountsMenuAndClickOnAllAccounts() {
		DriverUtility.moveHoverElement(moveAccounts);
		DriverUtility.click(allAccounts);
	}
	public void clickOnColumnIcon() {
		DriverUtility.click(columnIcon);
	}
	public void clickOnAddress2AndDescription(String... value) {
		DriverUtility.clickOnCheckbox(checkboxes, value);
	}
	public boolean checkAddress2AndDescriptionColumn() {
		List<WebElement> heading=columns;
    	ArrayList<String> alExp = new ArrayList<String>();
    	ArrayList<String> alAct = new ArrayList<String>();
    	
    	alExp.add("Address 2");
    	alExp.add("Description");
    	
    	
    	for (WebElement list : heading) {
			String account=list.getText();
			alAct.add(account);
		}
    	if(alAct.equals(alExp)) {
    		System.out.println("Title is matched");
    		return true;
    	}else {
    		System.out.println("Title is not matched");
    	return false;
    }
	}
}
