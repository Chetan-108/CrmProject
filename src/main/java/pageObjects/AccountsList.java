package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class AccountsList {

	WebDriver driver;

	public AccountsList(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[contains(@class,'open')]//a[text()='Lists']")
	public WebElement listBtn;
	
	@FindBy(xpath = "//tr[(@class='even') or (@class='odd') or (@class='odd bold')]//td[1]")
	public List <WebElement> accountsList;
	
	public void clickOnLists() {
		DriverUtility.click(listBtn);
	}
	
    public String getPageTitle() {
		
		return driver.getTitle();
	}
    public boolean checkAccountList() {
    	List<WebElement> heading=accountsList;
    	ArrayList<String> alExp = new ArrayList<String>();
    	ArrayList<String> alAct = new ArrayList<String>();
    	
    	alExp.add("All Accounts");
    	alExp.add("My Accounts");
    	alExp.add("New Accounts");
    	alExp.add("mangesh");
    	alExp.add("mangesh");
    	alExp.add("jbkstud");
    	alExp.add("pune");
    	alExp.add("mangesh");
    	alExp.add("mangesh");
    	
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
