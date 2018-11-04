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
	 * ����ʱ�� ���3��  �������� 1-3 ѧ�� ��ר н�ʣ� 1.5-2 ���䣺31-45 �Ա�Ů ״̬����ְ-���ǻ�
	 * 
	 * @throws Exception
	 */
	@Test
	public void search() throws Exception {
		// ��¼
		LoginAction la = new LoginAction(driver);
		// �����û���������
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		SearchItemAction.searchItem(driver, 18, 16, 5, "");
		SearchItemAction.sear(driver);
		//SearchItemAction.SearchExpansion(driver, 3, 4, 1, 1, 1, 3);
		//SearchItemAction.SearchOther(driver, 4, 2, 7, 1, 2, "����", "�����");
		SearchItemAction.SelectedContent(driver);
		SearchItemElement.SearchButton(driver).click();
        Thread.sleep(6000);
		CommonAction.takescreen(driver);
		if (!isElementPresent()) {
			System.out.println("�ؼ��֣�"
					+ SearchResultAction.tableCell(driver,"free" ,1, 5));
			System.out.println("ѧ����"
					+ SearchResultAction.tableCell(driver,"free" ,1, 6));
			System.out.println("�Ա�"
					+ SearchResultAction.tableCell(driver,"free" , 1, 9));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver,"free" , 1, 7));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver,"free" , 1, 8));
			System.out.println("�����أ�"
					+ SearchResultAction.tableCell(driver,"free" , 1, 10));
			System.out.println("����ʱ�䣺"
					+ SearchResultAction.tableCell(driver, "free" ,1, 11));
		}
	}
	/**
	 * ����ʱ�䣺���1��  �������� 3-5 ѧ��������  н�ʣ�2-3 ���䣺26-35 �Ա��� ״̬����ְ
	 * 
	 * @throws Exception
	 */
//	@Test
	public void search2() throws Exception {
//		LoginAction la = new LoginAction(driver);
//		// �����û���������
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
			System.out.println("�ؼ��֣�"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 5));
			System.out.println("ѧ����"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 6));
			System.out.println("�Ա�"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 9));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver, "free" , 1, 7));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 8));
			System.out.println("�����أ�"
					+ SearchResultAction.tableCell(driver, "free" , 1, 10));
			System.out.println("����ʱ�䣺"
					+ SearchResultAction.tableCell(driver, "free" , 1, 11));
		}
	}
	/**
	 * ����ʱ�� ���2�� �������� 5-10 ѧ����˶ʿ  н�ʣ�3-4.5 ���䣺20-25 �Ա𣺲��� ״̬������
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
			System.out.println("�ؼ��֣�"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 5));
			System.out.println("ѧ����"
					+ SearchResultAction.tableCell(driver, "free" , 1, 6));
			System.out.println("�Ա�"
					+ SearchResultAction.tableCell(driver,"free" ,  1, 9));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver, "free" , 1, 7));
			System.out.println("���䣺"
					+ SearchResultAction.tableCell(driver, "free" , 1, 8));
			System.out.println("�����أ�"
					+ SearchResultAction.tableCell(driver, "free" , 1, 10));
			System.out.println("����ʱ�䣺"
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
