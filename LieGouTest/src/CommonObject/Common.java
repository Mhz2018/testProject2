/**
 * 璇存槑锛氫负浜嗙畝鍖栨祴璇曚唬鐮侊紝鍏嶅緱婊″睆鐨刣river.findElement锛屽webdriver鐨勪竴浜涘父鐢ㄥ姛鑳界◢涓哄皝瑁呬簡涓�涓�

 * 浠ｇ爜閲岀敤鐨勬槸chromedriver锛屽叾浠栨祻瑙堝櫒鐨勮嚜琛屾洿鏀逛簡
 * byXXX锛�       鏌ユ壘WebElement鍏冪礌锛屼緥濡俠yId("abc"锛夋槸鏌ユ壘id=123鐨勫厓绱�
 * byXXXs:       鏌ユ壘鎵�鏈夌鍚堟潯浠剁殑WebElement鍏冪礌,杩斿洖list<WebElement>
 * clickXXX:     鐐瑰嚮绗﹀悎鏉′欢鐨勭涓�涓猈ebElement
 * setTextToXXX  杈撳叆妗嗚缃��
 * login 鐧诲綍
 * logout 閫�鍑猴紝鍏抽棴娴嬭瘯
 * 绀轰緥浠ｇ爜瑙侊細SampleTestCase
 * 
 * @author ArchieYao 
 * Copyright [2015] 
 * 
 */
package CommonObject;

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

public class Common {
	public static final int WAIT_4_ELEMENT = 30;
	public static final int WAIT_4_ELEMENT_INVISIBLE = 10;
	public static String baseUrl = "http://www.baidu.com";
	public static WebDriver driver = new FirefoxDriver();
	static {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	void login() {
		
	}
	/*
	 * 鏇夸唬 driver.get(url)
	 */
	public static void browser(String url) throws Exception {
		driver.get(url);
	}

	/*
	 * find visible & clickable element
	 * 鏌ユ壘鍙銆佸彲鐐瑰嚮鍏冪礌
	 */
	public static WebElement byId(String id) throws Exception {
		return Waits.waitForElementClickable(driver, By.id(id), WAIT_4_ELEMENT);
	}

	public static WebElement byXpath(String xpath) throws Exception {
		return Waits.waitForElementClickable(driver, By.xpath(xpath),WAIT_4_ELEMENT);
	}

	public static WebElement byLinkText(String linkText) throws Exception {
		return Waits.waitForElementClickable(driver, By.linkText(linkText),WAIT_4_ELEMENT);
	}

	public static WebElement byPartLinkText(String linkText) throws Exception {
		return Waits.waitForElementClickable(driver,By.partialLinkText(linkText), WAIT_4_ELEMENT);
	}

	public static WebElement byName(String name) throws Exception {
		return Waits.waitForElementClickable(driver, By.name(name),WAIT_4_ELEMENT);
	}

	public static WebElement byClassName(String className) throws Exception {
		return Waits.waitForElementClickable(driver, By.className(className),WAIT_4_ELEMENT);
	}
	
	/*
	 * find elements
	 * 鑾峰彇澶氫釜鍏冪礌
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
	 * 鏌ユ壘鍏冪礌骞剁偣鍑�
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
	 * 鏌ユ壘鍏冪礌锛屾竻闄ゅ綋鍓嶆暟鎹苟杈撳叆鏂版暟鎹�
	 */
	public static void setTextToId(String id, String keys) throws Exception {
		WebElement element = byId(id);
		element.clear();
		element.sendKeys(keys);
	}

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
	public static void setTextToName(String name, String keys)
			throws Exception {
		WebElement element = byName(name);
		element.clear();
		element.sendKeys(keys);
	}

	public static void setTextToClassName(String name, String keys)
			throws Exception {
		WebElement element = byClassName(name);
		element.clear();
		element.sendKeys(keys);
	}

	/*
	 * select an option
	 * 涓嬫媺閫夋嫨
	 */
	public static void selectBy(WebElement element, String name)
			throws Exception {
		if (!element.getAttribute("value").equals("Name"))
			new Select(element).selectByVisibleText(name);
	}

	/*
	 * wait for element invisible
	 * 绛夊緟鍏冪礌涓嶅彲瑙�
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
	 * 鏍规嵁frame name 杞埌鐩稿簲鐨刦rame
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
	 * 鏍规嵁 locator 杞埌鐩稿簲鐨刦rame
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
	 * 鍕鹃�夎〃鏍间腑鐨勬寚瀹氳(鏈夐�夋嫨妗�)
	 */
	public static void checkedTableRow(String object) throws Exception {
		clickXpath("//td/div[@title='"
				+ object
				+ "']/parent::*/preceding-sibling::*//input[@class='grid-body-checkbox']");
	}

	/*
	 * select a table row
	 * 瀵筎able鎿嶄綔,閫夋嫨琛岋紙娌℃湁閫夋嫨妗嗙殑琛ㄦ牸)
	 */
	public static void selectTableRow(String object) throws Exception {
		clickXpath("//td/div[@title='" + object + "']");
	}

	/*
	 * 瀵筎able鎿嶄綔,閫夋嫨琛屽苟鎵ц鐩稿叧鎿嶄綔
	 */
	public static void operateTableRow(String object, String operator)
			throws Exception {
		clickXpath("//td/div[@title='" + object
				+ "']/parent::*/following-sibling::*//a[@title='" + operator
				+ "']");
	}

	/*
	 * select tree node
	 * 閫夋嫨鏍戣妭鐐�
	 */
	public static void selectTreeItem(String itemName) throws Exception {
		clickXpath("//span[contains(text(), '" + itemName + "')]");
	}

	/*
	 * checked tree node
	 * 鍕鹃�夋爲鑺傜偣
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
	 * 鐧诲綍
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
//		getElementByCssSelector(LoginPage.loginCssName).click();
//	}
//	public static void openLoginDialog() throws Exception {
////		WebElement clickElement = getElementByCssSelector(LoginPage.openLoginCssName);
//		WebElement clickElement = getElementByXpath(LoginPage.openLoginCssName);
//		clickElement.click();
//		
//		clickId(LoginPage.openLoginId);
//		clickXpath(LoginPage.loginXpath);
//	}
//	private static WebElement getElementByXpath(String openLoginCssName) {
//		return driver.findElement(By.xpath(openLoginCssName));
//	}
}
