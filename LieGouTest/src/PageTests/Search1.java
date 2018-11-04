package PageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class Search1 {
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
	 * 更新时间 最近3天  工作经验 1-3 学历 大专 薪资： 1.5-2 年龄：31-45 性别：女 状态：在职-考虑换
	 * 
	 * @throws Exception
	 */
	@Test
	public void search() throws Exception {
		// 登录
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver, 18, 16, 5, "");
		SearchItemAction.sear(driver);
		//SearchItemAction.SearchExpansion(driver, 3, 4, 1, 1, 1, 3);
		//SearchItemAction.SearchOther(driver, 4, 2, 7, 1, 2, "衡阳", "计算机");
		SearchItemAction.SelectedContent(driver);
		SearchItemElement.SearchButton(driver).click();
        Thread.sleep(6000);
		CommonAction.takescreen(driver);
		if (!isElementPresent()) {
			System.out.println("关键字："
					+ SearchResultAction.tableCell(driver,"free" ,1, 5));
			System.out.println("学历："
					+ SearchResultAction.tableCell(driver,"free" ,1, 6));
			System.out.println("性别："
					+ SearchResultAction.tableCell(driver,"free" , 1, 9));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver,"free" , 1, 7));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver,"free" , 1, 8));
			System.out.println("期望地："
					+ SearchResultAction.tableCell(driver,"free" , 1, 10));
			System.out.println("更新时间："
					+ SearchResultAction.tableCell(driver, "free" ,1, 11));
		}
	}
	/**
	 * 更新时间：最近1周  工作经验 3-5 学历：本科  薪资：2-3 年龄：26-35 性别：男 状态：离职
	 * 
	 * @throws Exception
	 */
//	@Test
	public void search2() throws Exception {
//		LoginAction la = new LoginAction(driver);
//		// 输入用户名、密码
//		la.Login("tangboanan@qq.com", "123456");
		
		SearchItemElement.clear(driver).click();
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver, 10, 3, 1, "");
		SearchItemAction.SearchExpansion(driver, 3, 3, 2, 2, 2);
		SearchItemAction.SearchOther(driver, 3, 1, 7, 1, 1, "", "");
		SearchItemAction.SelectedContent(driver);
		SearchItemElement.SearchButton(driver).click();

		CommonAction.takescreen(driver);
		if (!isElementPresent()) {
			System.out.println("关键字："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 5));
			System.out.println("学历："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 6));
			System.out.println("性别："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 9));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver, "free" , 1, 7));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 8));
			System.out.println("期望地："
					+ SearchResultAction.tableCell(driver, "free" , 1, 10));
			System.out.println("更新时间："
					+ SearchResultAction.tableCell(driver, "free" , 1, 11));
		}
	}
	/**
	 * 更新时间 最近2周 工作经验 5-10 学历：硕士  薪资：3-4.5 年龄：20-25 性别：不限 状态：不限
	 * 
	 * @throws Exception
	 */
//	@Test
	public void search3() throws Exception {
		SearchItemElement.clear(driver).click();
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver, 10, 3, 2, "");
		SearchItemAction.SearchExpansion(driver, 3, 2, 3, 3, 3);
		SearchItemAction.SearchOther(driver, 3, 1, 7, 1, 1, "", "");
		SearchItemAction.SelectedContent(driver);
		SearchItemElement.SearchButton(driver).click();

		CommonAction.takescreen(driver);
		if (!isElementPresent()) {
			System.out.println("关键字："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 5));
			System.out.println("学历："
					+ SearchResultAction.tableCell(driver, "free" , 1, 6));
			System.out.println("性别："
					+ SearchResultAction.tableCell(driver,"free" ,  1, 9));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver, "free" , 1, 7));
			System.out.println("工龄："
					+ SearchResultAction.tableCell(driver, "free" , 1, 8));
			System.out.println("期望地："
					+ SearchResultAction.tableCell(driver, "free" , 1, 10));
			System.out.println("更新时间："
					+ SearchResultAction.tableCell(driver, "free" , 1, 11));
		}
	}

	private boolean isElementPresent() {

		try {
			driver.findElement(By
					.xpath("//img[@src='/static/img/noResume.3f7cb11.jpg']"));
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
