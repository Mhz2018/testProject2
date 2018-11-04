package PageAction;

import static org.junit.Assert.fail;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageElement.CommonElement;
import PageElement.TempPageElement;

public class CommonAction {

	private static String winHandleBefore="";
	//
	public static void openFirefox(WebDriver driver) {
		driver.get(CommonElement.baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static void openChrome(WebDriver driver) {
		
	  	driver.get(CommonElement.baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();

	}

	/*
	 * 元素是否存在
	 */
	private boolean iselementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static WebElement getElementByXpath(WebDriver driver, String xPath) throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath(xPath));
	}

	public static List<WebElement> getElementByXpaths(WebDriver driver,
			String xPath) {
		return driver.findElements(By.xpath(xPath));
	}

	public static WebElement getElementByCss(WebDriver driver, String css) {
		return driver.findElement(By.cssSelector(css));
	}

	public static void clickAllDom(WebDriver driver, WebElement element)
			throws Exception {
		// 获得元素，该元素直接点击会报“element not visible”，所以用js来执行点击事件
		// WebElement importBtn = driver.findElement(By.xpath(xPath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * 获取搜索页 上弹出窗 元素 条件1 -- 弹出div在 body 下最后 或者 条件2 -- 弹出div --
	 * div[@x-placement='top-start'] 或者 条件2 -- 弹出div --
	 * div[@x-placement='bottom-start']
	 * @throws Exception 
	 */
	public static WebElement getSearchPageDialogElement(WebDriver driver,
			String xPath) throws Exception {
		Thread.sleep(1000);
		if (xPath.startsWith("/html/body/div[")) {
			List<WebElement> elements = driver.findElements(By
					.xpath("/html/body/div"));
			for(int i=elements.size();i>0;i--){
				String divXpath = "/html/body/div[" + i + "]";
				WebElement divElement = getElementByXpath(driver, divXpath);
				if(divElement.isDisplayed()){
					xPath = xPath.substring(xPath.indexOf("/",
							"/html/body/div".length()));
					xPath = "/html/body/div[" + i + "]" + xPath;
					return getElementByXpath(driver, xPath);
				}else{
					continue;
				}
			}
			
		}
		return getElementByXpath(driver, xPath);
	}

	public static List<WebElement> getSearchPageDialogElements(
			WebDriver driver, String xPath) {
		if (xPath.startsWith("/html/body/div[")) {
			List<WebElement> elements = driver.findElements(By
					.xpath("/html/body/div"));
			xPath = xPath.substring(xPath.indexOf("/",
					"/html/body/div".length()));
			xPath = "/html/body/div[" + elements.size() + "]" + xPath;
		}
		return getElementByXpaths(driver, xPath);
	}

	/**
	 * 放弃，查找元素时间太长
	 * @throws Exception 
	 */
	public static WebElement getSearchPageDialogElementByXplacement(
			WebDriver driver, String xPath) throws Exception {
		if (xPath.startsWith("/html/body/div[")) {
			List<WebElement> elements = driver.findElements(By
					.xpath("/html/body/div[@x-placement='top-start']"));
			if (elements.size() > 0) {
				xPath = xPath.substring(xPath.indexOf("/",
						"/html/body/div".length()));
				xPath = "/html/body/div[@x-placement='top-start']" + xPath;
			} else {
				elements = driver.findElements(By
						.xpath("/html/body/div[@x-placement='bottom-start']"));
				if (elements.size() == 0) {
					return getElementByXpath(driver, xPath);
				}
				xPath = xPath.substring(xPath.indexOf("/",
						"/html/body/div".length()));
				xPath = "/html/body/div[@x-placement='bottom-start']" + xPath;
			}
		}
		return getElementByXpath(driver, xPath);
	}

	/**
	 * 获取body下最后一个div
	 */
	public static WebElement getSearchPageDialogLastDivElement(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.xpath("/html/body/div"));
		return elements.get(elements.size() - 1);
	}

	/**
	 * 省
	 */
	public static WebElement province(WebDriver driver, int i) {
		WebElement lastDivElement = getSearchPageDialogLastDivElement(driver);
		WebElement element = lastDivElement.findElements(
				By.cssSelector("div.el-cascader-menus ul:nth-of-type(1) li"))
				.get(i);
		return element;
	}

	/**
	 * 市
	 */
	public static WebElement city(WebDriver driver, int j) {
		WebElement lastDivElement = getSearchPageDialogLastDivElement(driver);
		WebElement element = lastDivElement.findElements(
				By.cssSelector("div.el-cascader-menus ul:nth-of-type(2) li"))
				.get(j);
		return element;
	}

	/**
	 * 点击省/市
	 */
	public static void clickProvinceAndcity(WebDriver driver, int i, int j)
			throws Exception {
		CommonAction.clickAllDom(driver, CommonAction.province(driver, i));
		CommonAction.clickAllDom(driver, CommonAction.city(driver, j));
	}

	/*
	 * 无搜索结果
	 */
	public static void searchWu(WebDriver driver) throws InterruptedException {
		// 无结果的情况下
		// TODO Auto-generated method stub
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(
						driver,
						By.xpath("//div[@id='app']/div/div[2]/div/div[3]/div/div/div[3]/div/span/div/div[2]/img")))
					break;
			} catch (Exception e) {
			}
		}
		Thread.sleep(1000);
	}

	/**
	 * 是否存在元素
	 */
	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 截屏操作 图片已当前时间命名
	 */

	public static void takescreen(WebDriver driver) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 转换时间格式
		String time = dateFormat.format(Calendar.getInstance().getTime()); // 获取当前时间
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE); // 执行屏幕截取
		org.apache.commons.io.FileUtils.copyFile(srcFile, new File("屏幕截图", time
				+ ".png")); // 利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
		Thread.sleep(2000);
	}
	/**
	 * 切换两个句柄
	 *
	 */
	public static void switchtowindow(WebDriver driver) throws Exception {
		//窗口切换，获取窗口句柄
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (winHandle.equals(winHandleBefore)) {
				continue;
			} else {
				driver.switchTo().window(winHandle);
				break;
			}
		}
	}
	/**
	 * 切换第几个句柄
	 *
	 */
	public static void switchToWindow(WebDriver driver, int windowNum) throws Exception {
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 int maxNum = tabs.size();
		 String handle = "";
		 if(windowNum <= maxNum) {
			 handle = tabs.get(windowNum-1);
		 }else {
			 handle = tabs.get(maxNum-1);
		 }
		 driver.switchTo().window(handle);
	}
	/**
	 * 人才管理页搜索公用模块
	 * @throws Exception 
	 */
	public static void resumeRearch(WebDriver driver) throws Exception {
		
		TempPageElement.getJobPositionWebElement(driver).click();
		TempPageElement.getDropdownBoxWebElement(driver).click();
		TempPageElement.getUpdateDateWebElement(driver).click();
		TempPageElement.getDropdownBoxWebElement(driver).click();
		TempPageElement.getCollectDateWebElement(driver).click();
		TempPageElement.getDropdownBoxWebElement(driver).click();
	    TempPageElement.getKeysWebElement(driver).sendKeys("测试");
	    TempPageElement.getStartSearchWebElement(driver).click();
		
		
		
	}
	
	/**
	 * 得到当前时间前的日期
	 * @param type 类型
	 * @param num 天数
	 * @param dateFormat
	 * @return
	 */
	public static Date getDateByBefore(String type, int num) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (type) {
		case "day":
			calendar.add(Calendar.DAY_OF_YEAR, -1*num);
			break;
		case "week":
			calendar.add(Calendar.WEEK_OF_YEAR, -1*num);
			break;
		case "month":
			calendar.add(Calendar.MONTH, -1*num);
			break;
		case "year":
			calendar.add(Calendar.YEAR, -1*num);
			break;

		default:
			break;
		}
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 判断时间是否在[startDate, endDate]区间，注意时间格式要一致
	 * 
	 * @param nowDate
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isEffectiveDate(Date nowDate, Date startDate, Date endDate) {
		if(nowDate.getTime() == startDate.getTime() || nowDate.getTime() == endDate.getTime()) {
			return true;
		}
		Calendar date = Calendar.getInstance();
		date.setTime(nowDate);
		Calendar begin = Calendar.getInstance();
		begin.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		if(date.after(begin) && date.before(end)) {
			return true;
		}else {
			return false;
		}

	}
	
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		String dateFormat = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date startDate = CommonAction.getDateByBefore("day", 3);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("week", 1);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("week", 2);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("month", 1);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("month", 2);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("month", 3);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("month", 6);
		System.out.println(df.format(startDate));
		startDate = CommonAction.getDateByBefore("year", 1);
		System.out.println(df.format(startDate));
		Date endDate = CommonAction.getDateByBefore("year", 1);
		System.out.println(df.format(endDate));
	}
	
	
}
