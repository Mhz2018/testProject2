package PageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class CommonElement {
	
	public static String baseUrl = "http://web.ailiegou.com";
	public static String homePage="//ul[@class='el-menu-demo el-menu']/li[1]";
	public static String searchPage="//ul[@class='el-menu-demo el-menu']/li[2]";
	public static String localTalent="//ul[@class='el-menu-demo el-menu']/li[3]";
	public static String warningTalent="//ul[@class='el-menu-demo el-menu']/li[4]";
	public static String attentionRecommend="//ul[@class='el-menu-demo el-menu']/li[5]";
	public static String jobManagement="//ul[@class='el-menu-demo el-menu']/li[6]";
	//下拉框
	//public static String dropdown="";
	/**
	 * 首页
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getHomePage(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, homePage);
	}
	/**
	 * 关注预警
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getAttentionRecommend(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, attentionRecommend);
	}
	/**
	 * 搜索页
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getSearchPage(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, searchPage);
	}
	/**
	 * 本地人才库
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getLocalTalent(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		return CommonAction.getElementByXpath(driver, localTalent);
	}
	/**
	 * 人才预警
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getWarningTalent(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, warningTalent); 
	}
	/**
	 * 职位管理
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getJobManagement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, jobManagement); 
	}
	
	
}
