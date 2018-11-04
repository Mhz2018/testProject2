package CommonObject;

/**
 * 说明：为了简化测试代码，免得满屏的driver.findElement，对webdriver的一些常用功能稍为封装了一下

 * 代码里用的是chromedriver，其他浏览器的自行更改了
 * byXXX：       查找WebElement元素，例如byId("abc"）是查找id=123的元素
 * byXXXs:       查找所有符合条件的WebElement元素,返回list<WebElement>
 * clickXXX:     点击符合条件的第一个WebElement
 * setTextToXXX  输入框设置值
 * login 登录
 * logout 退出，关闭测试
 * 示例代码见：SampleTestCase
 * 
 * @author ArchieYao 
 * Copyright [2015] 
 * 
 */

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import jxl.*;

public class Common2 {
	public static final int WAIT_4_ELEMENT = 30;
	public static final int WAIT_4_ELEMENT_INVISIBLE = 10;
	public static String baseUrl = "http://192.168.0.150:81/";
	public static WebDriver driver = new FirefoxDriver();
	static {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	void login() {
		
	}
	/*
	 * 替代 driver.get(url)
	 */
	public static void browser(String url) throws Exception {
		driver.get(url);
	}

	/*
	 * find visible & clickable element
	 * 查找可见、可点击元素
	 */

	public static WebElement byXpath(String xpath) throws Exception {
		return Waits.waitForElementClickable(driver, By.xpath(xpath),WAIT_4_ELEMENT);
	}
//	private static WebElement getElementByXpath1(String openLoginCssName) {
//		return driver.findElement(By.xpath(openLoginCssName));
//	}
	
	/*
	 * find elements
	 * 获取多个元素
	 */
	public static List<WebElement> byIds(String id) throws Exception {
		return driver.findElements(By.id(id));
	}
	
	public static List<WebElement> byXpaths(String xpath) throws Exception {
		return driver.findElements(By.xpath(xpath));
	}

	public static List<WebElement> byLinkTexts(String linkText) throws Exception {
		return driver.findElements(By.linkText(linkText));
	}

	public static List<WebElement> byPartLinkTexts(String linkText) throws Exception {
		return driver.findElements(By.partialLinkText(linkText));
	}

	public static List<WebElement> byNames(String name) throws Exception {
		return driver.findElements(By.name(name));
	}

	public static List<WebElement> byClassNames(String className) throws Exception {
		return driver.findElements(By.className(className));
	}
	
	/*
	 * find element and click
	 * 查找元素并点击
	 */
	public static void clickId(String id) throws Exception {
		Waits.waitForElementClickable(driver, By.id(id), WAIT_4_ELEMENT)
				.click();
	}

	public static void clickXpath(String xpath) throws Exception {
		Waits.waitForElementClickable(driver, By.xpath(xpath), WAIT_4_ELEMENT)
				.click();
	}

	public static void clickLink(String linkText) throws Exception {
		Waits.waitForElementClickable(driver, By.linkText(linkText),WAIT_4_ELEMENT).click();
	}

	public static void clickPartLink(String linkText) throws Exception {
		Waits.waitForElementClickable(driver, By.partialLinkText(linkText),WAIT_4_ELEMENT).click();
	}

	public static void clickName(String name) throws Exception {
		Waits.waitForElementClickable(driver, By.name(name), WAIT_4_ELEMENT).click();
	}

	public static void clickClassName(String className) throws Exception {
		Waits.waitForElementClickable(driver, By.className(className),WAIT_4_ELEMENT).click();
	}

	/*
	 * Replace driver.findelement().sendkeys() find element -> clear -> sendkeys
	 * 查找元素，清除当前数据并输入新数据
	 */
//	public static void setTextToId(String id, String keys) throws Exception {
//		WebElement element = byId(id);
//		element.clear();
//		element.sendKeys(keys);
//	}

	public static void setTextToXpath(String xpath, String keys)
			throws Exception {
		WebElement element = byXpath(xpath);
		element.clear();
		element.sendKeys(keys);
	}
/*
	public static void sendKeysToLink(String linkText, String keys)
			throws Exception {
		WebElement element = byLinkText(linkText);
		element.clear();
		element.sendKeys(keys);
	}

	public static void sendKeysToPartLink(String linkText, String keys)
			throws Exception {
		WebElement element = byLinkText(linkText);
		element.clear();
		element.sendKeys(keys);
	}
*/
//	public static void setTextToName(String name, String keys)
//			throws Exception {
//		WebElement element = byName(name);
//		element.clear();
//		element.sendKeys(keys);
//	}
//
//	public static void setTextToClassName(String name, String keys)
//			throws Exception {
//		WebElement element = byClassName(name);
//		element.clear();
//		element.sendKeys(keys);
//	}

	/*
	 * select an option
	 * 下拉选择
	 */
	public static void selectBy(WebElement element, String name)
			throws Exception {
		if (!element.getAttribute("value").equals("Name"))
			new Select(element).selectByVisibleText(name);
	}

	/*
	 * wait for element invisible
	 * 等待元素不可见
	 */
	public static void waitInvisibleBy(String type, String name)
			throws Exception {
		type = type.toUpperCase();
		if (type.equals("ID"))
			Waits.waitForElementInvisible(driver,
					driver.findElement(By.id(name)), WAIT_4_ELEMENT_INVISIBLE);
		else if (type.equals("XPATH"))
			Waits.waitForElementInvisible(driver,
					driver.findElement(By.xpath(name)),
					WAIT_4_ELEMENT_INVISIBLE);
		else if (type.equals("LINKTEXT"))
			Waits.waitForElementInvisible(driver,
					driver.findElement(By.linkText(name)),
					WAIT_4_ELEMENT_INVISIBLE);
		else if (type.equals("NAME"))
			Waits.waitForElementInvisible(driver,
					driver.findElement(By.name(name)), WAIT_4_ELEMENT_INVISIBLE);
		else if (type.equals("CLASSNAME"))
			Waits.waitForElementInvisible(driver,
					driver.findElement(By.className(name)),
					WAIT_4_ELEMENT_INVISIBLE);
	}

	/*
	 * Switch to frame by frame name
	 * 根据frame name 转到相应的frame
	 */
	public static void switchToFrame(String frameName) throws Exception {
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_4_ELEMENT);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frameName));
		Thread.sleep(1000);
	}

	/*
	 * Switch to frame by locator
	 * 根据 locator 转到相应的frame
	 */
	public static void switchToFrame(By locator) throws Exception {
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		driver.manage().timeouts().implicitlyWait(Waits.DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	/*
	 * checked a table row
	 * 勾选表格中的指定行(有选择框)
	 */
	public static void checkedTableRow(String object) throws Exception {
		clickXpath("//td/div[@title='"
				+ object
				+ "']/parent::*/preceding-sibling::*//input[@class='grid-body-checkbox']");
	}

	/*
	 * select a table row
	 * 对Table操作,选择行（没有选择框的表格)
	 */
	public static void selectTableRow(String object) throws Exception {
		clickXpath("//td/div[@title='" + object + "']");
	}

	/*
	 * 对Table操作,选择行并执行相关操作
	 */
	public static void operateTableRow(String object, String operator)
			throws Exception {
		clickXpath("//td/div[@title='" + object
				+ "']/parent::*/following-sibling::*//a[@title='" + operator
				+ "']");
	}

	/*
	 * select tree node
	 * 选择树节点
	 */
	public static void selectTreeItem(String itemName) throws Exception {
		clickXpath("//span[contains(text(), '" + itemName + "')]");
	}

	/*
	 * checked tree node
	 * 勾选树节点
	 */
	public static void clickTreeItem(String itemName) throws Exception {
		clickXpath("//span[contains(text(), '" + itemName
				+ "')]/preceding-sibling::input[@class='tree-node-checkbox']");
	}
/*
 * assert not exists for valdiate delete row
 */
	public static void assertRowNotExists(String object) throws Exception {
		assertTrue(driver.findElements(
				By.xpath("//td/div[@title='" + object + "']")).size() < 1);
	}

	/*
	 * login
	 * 登录
	 */
	public static void login(String string, String string2) throws Exception {
		browser(baseUrl);
//		browser(baseUrl + "/login.jsp");
//		sendKeysToId("name", user);
//		sendKeysToId("pwd", password);
//		clickLink("login");
	}

	/*
	 * logOut
	 */
//	public static void logout(String module) throws Exception {
//		driver.get(baseUrl);
//		clickLink(LoginElement.loginButtonId);
//		clickLink(LoginElement.logoutButtonId);
//	}

	/*
	 * get date before/after N days
	 */
	public static String getDateDiff(int diff) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE, diff);
		String diffDate = sdf.format(calendar.getTime());
		return diffDate;
	}

	/*
	 * set value to Read Only Object by id
	 */
	public static void setValueToReadOnlyElementById(String elementId,
			String value) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('"
				+ elementId + "').value='" + value + "'");
	}

	/*
	 * read data from excel file(only for .xls)
	 */
	public static String[][] getTableArray(String xlFilePath, String sheetName,
			String tableName) throws Exception {
		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		jxl.Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		jxl.Cell tableEnd = sheet.findCell(tableName, startCol + 1,
				startRow + 1, 100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
				+ "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);
	}

	@AfterSuite
	public void endTestSuite() {
		driver.quit();
	}
//	public static void fengZhuangFangFa(String aa) {
//		aa.click();
//		
//	}
//	public static WebElement getElementByCssSelector(String cssName) {
//		 return driver.findElement(By.cssSelector(cssName));
//	}
//	public static void clickElement() {
//		
//		getElementByCssSelector(LoginElement.loginCssName).click();
//	}
//	public static void openLoginDialog() throws Exception {
////		WebElement clickElement = getElementByCssSelector(LoginPage.openLoginCssName);
//		WebElement clickElement = getElementByXpath1(LoginElement.openLoginCssName);
//		clickElement.click();
//		
//		clickId(LoginElement.openLoginId);
//		clickXpath(LoginElement.loginXpath);
//	}
	
}

