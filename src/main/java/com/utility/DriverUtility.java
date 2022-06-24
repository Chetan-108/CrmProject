package com.utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefination.Step;



public class DriverUtility extends Step{

	public static void click(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.click();
	}
	public static void sendKeys(WebElement elem, String value) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));
		elem.click();
		elem.sendKeys(value);
	}
	public static void expliciteWait(WebElement elem) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(elem));

	}
	

	public static void selectRadioButton(List<WebElement> elems, String value) {
		for (WebElement locator : elems) {
			if (locator.getText().equalsIgnoreCase(value)) {
				locator.click();
				break;
			}
		}
	}

	public static void clickOnCheckbox(List<WebElement> elems, String... value) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		for (WebElement locator : elems) {
			for (String val : value) {
				if (locator.getAttribute("value").equalsIgnoreCase(val)) {
					wait.until(ExpectedConditions.elementToBeClickable(locator));
					locator.click();
					break;
				}
			}
		}
	}
	public static void selectMonthOrYear(WebElement element, String value) throws Exception {
		Select drp = new Select(element);
		drp.selectByVisibleText(value);
			}

	public static void selectDropDown(WebElement element, String value) throws Exception {
		Select drp = new Select(element);
		List<WebElement> allOptions = drp.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	public static void selectLanguageDropDown(List<WebElement> element1, WebElement element2, String... value)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element2.click();
		List<WebElement> allOptions = element1;
		for (WebElement option : allOptions) {
			for (String val : value) {
				if (option.getText().equals(val)) {
					wait.until(ExpectedConditions.elementToBeClickable(element2));
					option.click();
					break;
				}
			}
		}
	}

	public static void selectDate(List<WebElement> element1, String value) throws Exception {
	
		List<WebElement> allOptions = element1;
		for (WebElement option : allOptions) {

			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	public static void checkSorting1(List <WebElement> element1,ArrayList<String> originalList) throws Exception  {

		for(WebElement option:element1) {
			originalList.add(option.getText());		
		}}
	public static void checkSorting2(List <WebElement> element1,ArrayList<String> sortedList) throws Exception  {

		for(WebElement option:element1) {
			sortedList.add(option.getText());

		}}
	public static void switchIFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void scrollForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void robotClassMethod() throws Exception {
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection("D:\\Mix\\images (5).jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//CTR+C
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);		
	}
	public static void moveHoverElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public static void doubleClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public static void sliderByDrag(WebElement element,int a,int b) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, a, b).perform();

	}
//	public static DataFormatter df = new DataFormatter();
//	//public static int count ;
//	public static int column ;
//	public static String getCellData(String filePath, String sheetName, int count, int col) throws Exception {
//		FileInputStream fis = new FileInputStream(filePath);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetName);
//		return df.formatCellValue(sh.getRow(count).getCell(column));
//	}
	
}
