package PageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonObject.Common2;
import PageAction.CommonAction;
import PageAction.LoginAction;
import PageAction.ResumeAction;
import PageAction.TempResumeAction;
import PageElement.CommonElement;
import PageElement.LoginElement;
import PageElement.ResumeElement;
import PageElement.TempPageElement;

public class TempSearch {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void runBeforClass() throws Exception {
		System.getProperties()
				.setProperty(
						"webdriver.chrome.driver",
						"C:/Users/Administrator/AppData/Local/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		CommonAction.openChrome(driver);

	}

	/**
	 * 暂存页搜索-搜索条件 模糊下拉框的第3个元素
	 * 
	 * @throws Exception
	 */
	 @Test(priority = 0)
	public void tempSearch() throws Exception {
		// 登录
		Thread.sleep(1000);
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		CommonElement.getLocalTalent(driver).click();
		TempPageElement.getTempStoreWebElement(driver).click();
		CommonAction.resumeRearch(driver);
		Thread.sleep(2000);
		CommonAction.takescreen(driver);
	}

	/**
	 * 暂存页搜索结果 
	 * 点击获取联系方式
	 * 转发评审
	 * 
	 * @throws Exception
	 */
//	@Test(priority = 1)
	public void tempResult() throws Exception {
		// 登录
		Thread.sleep(1000);
		LoginAction la = new LoginAction(driver);
	// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		CommonElement.getLocalTalent(driver).click();
		TempPageElement.getTempStoreWebElement(driver).click();
		String i=TempPageElement.getTempStorenumWebElement(driver).getText();
		System.out.println(i);
		TempResumeAction.getPhotoTurnJudge(driver);
		driver.navigate().refresh();
		i=TempPageElement.getTempStorenumWebElement(driver).getText();
		System.out.println(i);
		TempResumeAction.getCancelStore(driver);
        
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
}
