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

public class Search {
	private WebDriver driver;
	private String baseUrl;
	private static String winHandleBefore = "";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void runBeforClass() throws Exception {
		driver = new FirefoxDriver();
		driver.get(CommonElement.baseUrl);
		driver.manage().window().maximize();

	}

	@Test
	/**
	 * 关键字：销售 测试;期望工作地：东莞市;更新时间：最近2月 
	 * 勾选是否正常 暂存是否正常 查看简历详情是否正常
	 * 
	 * @throws Exception
	 */
	public void searchBasics() throws Exception {
		Thread.sleep(1000);
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("2015069736@qq.com", "123456");
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver,18, 16, 5, "");
		SearchItemAction.sear(driver);
		SearchItemAction.SearchExpansionforconst(driver, 1, 1, 6);
		SearchItemElement.SearchButton(driver).click();
		CommonAction.takescreen(driver);
		Thread.sleep(10000);
		// SearchItemAction.SelectedContent(driver);
		
		// 搜索条件和结果对比
		SearchResultAction.compareConditionAndReault(driver);

		SearchResultAction.CheckOutTrue(driver);
		System.out.println("勾选正常");
		SearchResultAction.temporaryStorage(driver);
		System.out.println("暂存正常");
		// 查看简历
		CommonElement.getSearchPage(driver).click();
		SearchResultAction.CheckOut(driver, "free", 1, 3);
		CommonAction.switchtowindow(driver);
		System.out.println(driver.getTitle());
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
