package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class AccountsReportPage {

	WebDriver driver;

	public AccountsReportPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='open']//a[text()='Accounts Report']")
	public WebElement accReportBtn;
	
	@FindBy(xpath = "//select[@id='dateField']")
	public WebElement selectField;
	
	@FindBy(id = "startDate")
	public WebElement selectStartDt;
		
	@FindBy(xpath = "//select[@data-handler='selectMonth']")
	public WebElement startmonth;
	
	@FindBy(xpath = "//select[@data-handler='selectYear']")
	public WebElement startyear;
	
	@FindBy(xpath = "//a[@class='ui-state-default' or @class='ui-state-default ui-state-active']")
	public List <WebElement> date;
	
	@FindBy(xpath = "//input[@id='endDate']")
	public WebElement selectEndDt;
	
	@FindBy(xpath = "//select[@data-handler='selectMonth']")
	public WebElement endmonth;
	
	@FindBy(xpath = "//select[@data-handler='selectYear']")
	public WebElement endyear;
	
	@FindBy(xpath = "//select[@id='dateRange']")
	public WebElement selectDtRange;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement generate;
	
	@FindBy(xpath = "//h2[text()='Accounts']")
	public static WebElement heading;
	
	public void clickOnAccountReports() {
		DriverUtility.click(accReportBtn);
	}
    public String getTitleOfAccReportPg() {
		
	   return driver.getTitle();
	}
	public void chooseFieldType(String field) throws Exception {
		DriverUtility.selectDropDown(selectField,field);
	}
	public void chooseStartDt(String stmt,String styr,String value) throws Exception {
		DriverUtility.click(selectStartDt);
		Thread.sleep(2000);;
		DriverUtility.selectDropDown(startmonth,stmt);
		DriverUtility.selectDropDown(startyear,styr);
		DriverUtility.selectDate(date,value);
	}

	public void chooseEndDt(String enmn,String enyr,String value) throws Exception {
		DriverUtility.click(selectEndDt);
		Thread.sleep(2000);
		DriverUtility.selectDropDown(endmonth,enmn);
		DriverUtility.selectDropDown(endyear,enyr);
		DriverUtility.selectDate(date,value);
	}
	public void chooseDtRange(String range) throws Exception {
		DriverUtility.selectDropDown(selectField,range);
	}
	public void clickOnGenerate() {
		DriverUtility.click(generate);
	}
	
}
