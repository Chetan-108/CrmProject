package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtility;

public class DocsPage {

	WebDriver driver;

	public DocsPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='More']")
	public WebElement more;
	
	@FindBy(xpath = "//ul[@class='open']//a[text()='Docs']")
	public WebElement docs;
	
	@FindBy(id = "attachment-button")
	public WebElement uploadFile;
	
	@FindBy(xpath = "//span[@class='x2-button blue']")
	public WebElement selectFiles;
	
	@FindBy(xpath = "//a[text()='images_(5).jpeg']")
	public static WebElement uploadedFileName;
    public void moveToMoreMenuAndClickOnDocs() {
    	DriverUtility.moveHoverElement(more);
    	DriverUtility.click(docs);
    }
    public void clickOnUploadFile() {
    	DriverUtility.click(uploadFile);
    }
    public void clickOnSelectFiles() throws Exception {
    	DriverUtility.click(selectFiles);
    	//DriverUtility.robotClassMethod();
    	
    }
}
