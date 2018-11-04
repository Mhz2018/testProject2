package PageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class SearchResultElement {
	private static WebElement element;
	private static List<WebElement> elementlist;
	private static String pkButton="//*[@id='app']/div/div[1]";
	private static String Contrastpk="//button[@class='el-button pk-but bg-i-blue el-button--default']";
	private static String EmptyingButton="//div[@class='clear-pk cp']";
	private static String pknum="//div[@class='db-pk el-popover__reference']/div[@class='el-badge item enter']/sup[@class='el-badge__content is-fixed']";
	private static String deletebutton="//div[@class='clear-pk cp']";
	public static String FREE = "free";
	
	/**
	 * row行点击加入PK
	 * @throws Exception 
	 */
	public static WebElement joinpk(WebDriver driver,int row) throws Exception {
		element=driver.findElement(By.xpath("//div[@class='el-table__body-wrapper is-scrolling-none']/table[@class='el-table__body']/tbody/tr["+row+"]/td[13]/div/button"));
		
		//String joinpk="//div[@class='el-table__body-wrapper is-scrolling-none']/table[@class='el-table__body']/tbody/tr["+row+"]/td[13]/div/button/i/span";
	//	Thread.sleep(2000);
	//	return CommonAction.getElementByXpath(driver, joinpk);
		return element;
	//	SearchResultElement.hangshu(driver, i).g
	}
	/**
	 * pk按钮
	 * @throws Exception 
	 */
	public static WebElement pkButton(WebDriver driver ) throws Exception {
		return CommonAction.getElementByXpath(driver, pkButton);
	}
	/**
	 * 简历对比
	 * @throws Exception 
	 */
	public static WebElement Contrastpk(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, Contrastpk);
	}
	/**n   
	 * pk数
	 * @throws Exception 
	 */
	public static WebElement pknum(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, pknum);
	}	
	/**
	//div[@class='clear-pk cp'] * 删除pk人
	 * @throws Exception 
	 */
	public static WebElement deletebutton(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, deletebutton);
	}
	/**
	 * 列表数据
	 * @throws Exception 
	 */
	public static WebElement TableContent(WebDriver driver,String webName, int row,int column) throws Exception {
		
		row = row + 1;
		Thread.sleep(3000);
		String divXpath = "";
		switch (webName) {
		case "free" :
			getElementByXpath(driver, "//div[@id='tab-0']").click();
			divXpath = "//div[@id='app']/div/div[@class='content']/div/div[@class='sr-table']/div[1]/div[1]/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div";
			break;
		case "zhuobo":
			getElementByXpath(driver, "//div[@id='tab-4']").click();
			divXpath = "//div[@id='app']/div/div[@class='content']/div/div[@class='sr-table']/div[@class='socket']/div[@style='']/div[1]/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div";
			break;
		case "kunshan":
			getElementByXpath(driver, "//div[@id='tab-6']").click();
			divXpath = "//div[@id='app']/div/div[@class='content']/div/div[@class='sr-table']/div[@class='socket']/div[@style='']/div[1]/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div";
			break;

		default:
			getElementByXpath(driver, "//div[@id='tab-0']").click();
			divXpath = "//div[@id='app']/div/div[@class='content']/div/div[@class='sr-table']/div[1]/div[1]/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div";
			break;
		}
		WebElement element = getElementByXpath(driver, divXpath);
		return element;

	}
	private static WebElement getElementByXpath(WebDriver driver,String xPath) throws Exception {
		Thread.sleep(1000);
		return driver.findElement(By.xpath(xPath));
	}
	
	
	
}
