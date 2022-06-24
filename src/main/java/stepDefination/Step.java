package stepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountsList;
import pageObjects.AccountsReportPage;
import pageObjects.AllAccountsPage;
import pageObjects.CreateAccountPage;
import pageObjects.DocsPage;
import pageObjects.SignInPage;

public class Step {

	public SignInPage sp;
	public CreateAccountPage cp;
	public AccountsList al;
	public AccountsReportPage ar;
	public DocsPage dp;
	public AllAccountsPage ap;
	public static WebDriver driver;
	public static Logger logger;
	public static Properties configProp;

	@Before
	public void setup() throws Exception {
		 configProp = new Properties();
			
				 FileInputStream fis=new FileInputStream(".//src/main/resources/config.Properties");
				configProp.load(fis);
				String br=configProp.getProperty("browser");
	logger = Logger.getLogger("CRMTechProject");
	PropertyConfigurator.configure("src/main/resources/log4j.Properties");
		 logger.info("initialising a browser with name"+ br);
			try {
				if (br.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					 logger.info("launching an application");
					//driver.get(readProperty("url"));
					logger.info("chorme browser initialised");
					// return driver;
				} 
				else {
					System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
					driver = new FirefoxDriver();
					logger.info("firefox browser initialised");
					 logger.info("launching an application");
				//		driver.get(readProperty("url"));
					// return driver;
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	
	@Given("^User launch chrome browser$")
	public void user_launch_chrome_browser() throws Throwable {
	   sp=new SignInPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("^User enters userName as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_userName_as_and_password_as(String username, String pass) throws Throwable {
	   sp.setUserName(username);
	   sp.setPassword(pass);
	}

	@When("^click on Remember me$")
	public void click_on_Remember_me() throws Throwable {
	  sp.clickCheck();
	}

	@When("^double click on SignIn$")
	public void double_click_on_SignIn() throws Throwable {
	   sp.clickSignin();
	   
	}

	
	@Then("^User can view Homepage$")
	public void user_can_view_Homepage() throws Throwable {
	 cp=new CreateAccountPage(driver);
	 if(cp.getPageTitle().equals("CRM Tech - View Profile")) {
	 Assert.assertEquals("CRM Tech - View Profile", cp.getPageTitle());
	 }
	 else {
		 Assert.assertEquals("CRM Tech - Error 500", cp.getPageTitle());
	 }
	}

	@When("^User move to Accounts menu$")
	public void user_move_to_Accounts_menu() throws Throwable {
	   cp.moveToAccountsMenu();
	}

	@When("^click on create Account menu$")
	public void click_on_create_Account_menu() throws Throwable {
	   cp.clickOnCreateAccount();
	}

	@Then("^User can view create Account page$")
	public void user_can_view_create_Account_page() throws Throwable {
	   cp.getTitleOfCreateAccountPage();
	}

	@When("^User enter client info$")
	public void user_enter_client_info() throws Throwable {
		cp.enterName("ChetankumarGangavane");
		cp.enterEmail("chetan123@gmail.com");
		cp.selectLeadType("Web");
		cp.selectLeadSource("Google");
		cp.selectLeadStatus("Assigned");
		cp.selectDealStatus("Working");
	}

	@When("^click on create button$")
	public void click_on_create_button() throws Throwable {
	   cp.clickOnCreate();
	}

	@Then("^User can view Heading$")
	public void user_can_view_Heading() throws Throwable {

		Thread.sleep(3000);
		Assert.assertTrue(CreateAccountPage.heading.getText().contains(" ChetankumarGangavane"));
	
	}

	@When("^click on Lists$")
	public void click_on_Lists() throws Throwable {
	   al=new AccountsList(driver);
	   al.clickOnLists();
	
	}

	@Then("^User can view Account Lists page$")
	public void user_can_view_Account_Lists_page() throws Throwable {
		 al=new AccountsList(driver);
		 Assert.assertEquals("Account Lists", al.getPageTitle());
	}

	@Then("^verify List$")
	public void verify_List() throws Throwable {
	    Assert.assertTrue(al.checkAccountList());
	}
	
	@When("^click on Accounts Report$")
	public void click_on_Accounts_Report() throws Throwable {
	    ar=new AccountsReportPage(driver);
	    ar.clickOnAccountReports();
	}

	@Then("^User can view Accounts Report Page$")
	public void user_can_view_Accounts_Report_Page() throws Throwable {
	    ar.getTitleOfAccReportPg();
	}

	@When("^User enter Accounts Report info$")
	public void user_enter_Accounts_Report_info() throws Throwable {
	   ar.chooseFieldType("createDate");
	   ar.chooseStartDt("Apr","2021","18");
	   ar.chooseEndDt("Mar","2022","27");
	   ar.chooseDtRange("This Month");
	}

	@When("^click on Generate button$")
	public void click_on_Generate_button() throws Throwable {
	   ar.clickOnGenerate();
	}
	@Then("^User can view Heading of Report List$")
	public void user_can_view_Heading_of_Report_List() throws Throwable {
		Assert.assertTrue(AccountsReportPage.heading.getText().contains("Accounts"));
		Thread.sleep(3000);
	}
	@When("^User move to More menu and click on docs$")
	public void user_move_to_More_menu_and_click_on_docs() throws Throwable {
		 dp=new DocsPage(driver);
		 dp.moveToMoreMenuAndClickOnDocs();
	}

	@When("^click on upload file$")
	public void click_on_upload_file() throws Throwable {
	   dp.clickOnUploadFile();
	}

	@When("^click on Select files$")
	public void click_on_Select_files() throws Throwable {
	   dp.clickOnSelectFiles();
	   Thread.sleep(3000);
	}
	@Then("^User can view uploaded file$")
	public void user_can_view_uploaded_file() throws Throwable {
		Assert.assertTrue(DocsPage.uploadedFileName.getText().contains("images_(5).jpeg"));
	}
	@When("^User move to Accounts menu and click on All Accounts$")
	public void user_move_to_Accounts_menu_and_click_on_All_Accounts() throws Throwable {
		 ap=new AllAccountsPage(driver);
		 ap.moveToAccountsMenuAndClickOnAllAccounts();
	}

	@When("^click on column icon$")
	public void click_on_column_icon() throws Throwable {
	   ap.clickOnColumnIcon();
	}

	@When("^click on Address(\\d+) and Description$")
	public void click_on_Address_and_Description(int arg1) throws Throwable {
		ap.clickOnAddress2AndDescription("address2","description");
	}

	@Then("^User can view Address(\\d+) and Description column in Accounts table$")
	public void user_can_view_Address_and_Description_column_in_Accounts_table(int arg1) throws Throwable {
	    Assert.assertTrue(ap.checkAddress2AndDescriptionColumn());
	}
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	   driver.close();
	}
}
