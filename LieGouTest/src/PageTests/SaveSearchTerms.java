package PageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageAction.CommonAction;
import PageAction.LoginAction;
import PageAction.SearchItemAction;
import PageAction.SearchResultAction;
import PageElement.CommonElement;
import PageElement.SearchItemElement;
import PageElement.SearchResultElement;

public class SaveSearchTerms {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void runBeforClass() throws Exception {
		driver = new FirefoxDriver();
		driver.get(CommonElement.baseUrl);
		driver.manage().window().maximize();
		
	}
	
	/**
	 * 全部项搜索
	 * 保存到搜索器（断言搜索项个数）
	 * 
	 * @throws Exception
	 */
	@Test
	public void search1() throws Exception {
		// 登录
		Thread.sleep(1000);
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver,18,16,1,"健客");
		SearchItemAction.SearchExpansion(driver, 3, 4, 2, 3, 2);
		SearchItemAction.Highlyeducated(driver, 3);
		SearchItemAction.SearchOther(driver, 5,1,2, 1, 1, "衡阳", "计算机");
		SearchItemAction.SelectedContent(driver);
		
		SearchItemAction.Savetolist(driver);
		SearchItemElement.delete(driver).click();
		SearchItemElement.SearchButton(driver).click();	
		//CommonAction.searchWu(driver);
		CommonAction.takescreen(driver);
		
	}
	//SearchResultAction.tableCell(driver, 3, 5);

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
}
