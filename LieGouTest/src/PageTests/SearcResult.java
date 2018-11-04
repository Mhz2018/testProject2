package PageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonObject.Common2;
import PageAction.CommonAction;
import PageAction.LoginAction;
import PageAction.SearchItemAction;
import PageAction.SearchResultAction;
import PageElement.SearchItemElement;
import PageElement.SearchResultElement;

public class SearcResult {
	private WebDriver driver;
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void runBeforClass() throws Exception {
		driver= new FirefoxDriver();
		CommonAction.openFirefox(driver);
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);

	}


	@Test
	public void ResumeContrast() throws Exception {
		
		Thread.sleep(1000);
		SearchItemElement.SearchList(driver).click();
		Thread.sleep(3000);
		
		System.out.println(SearchResultAction.tableCell(driver,"free", 3, 3));
		SearchResultElement.joinpk(driver, 2).click();
		SearchResultElement.joinpk(driver, 3).click();
		SearchResultElement.pkButton(driver);
		Thread.sleep(2000);
		String i = SearchResultElement.pknum(driver).getText();
		assertEquals(i, "2");
		SearchResultElement.pkButton(driver).click();
		SearchResultElement.Contrastpk(driver).click();
		//CommonAction.;
		System.out.println(driver.getTitle());
		// driver.switchTo().window();
		 SearchResultElement.deletebutton(driver).click();

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
