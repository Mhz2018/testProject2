package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class RegisterElement {
	private static WebElement element;
	
	//非本class使用的定义 用 public
	public static String registerEnterpriseName = "企业1";//注册 -- 企业名称
	public static String registerUserName = "世界";//注册 -- 用户名称
	public static String registerMailBox = "1071516738@qq.com";//注册 -- 邮箱
	public static String registerMobilePhone = "15217376381";//注册 -- 电话
	public static String registerPositionName = "助理";//注册 -- 职位
	
	//本class使用的定义 public/private 都可以
	private static String MESSAGE_BOX = "//div[@class='el-message-box__message']";
	private static String USE_NAME = "(//input[@type='text'])[2]";
	private static String EnterpriseName = "input.el-input__inner";

	public static WebElement EnterpriseName(WebDriver driver) {
		// 企业名称
		/*
		 * element = driver.findElement(By.cssSelector("input.el-input__inner")); 
		 * return element;
		 */
		return CommonAction.getElementByCss(driver, EnterpriseName);
	}

	public static WebElement UseName(WebDriver driver) throws Exception {
		// 姓名
		/*
		 * element = driver.findElement(By.xpath("(//input[@type='text'])[2]")); return
		 * element;
		 */
		return CommonAction.getElementByXpath(driver, USE_NAME);
	}

	public static WebElement Mailbox(WebDriver driver) {
		// 邮箱
		element = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		return element;
	}

	public static WebElement MobilePhone(WebDriver driver) {
		// 手机号
		element = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		return element;
	}

	public static WebElement PositionName(WebDriver driver) {
		// 职位
		element = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		return element;
	}

	public static WebElement Agreement(WebDriver driver) throws InterruptedException {
		// 协议
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/form/div[6]/span"));
		// span[@class='fs13 mr5 cp c-i-blue']
		return element;
	}

	public static WebElement AgreementAgree(WebDriver driver) {
		// 协议同意
		element = driver.findElement(By.cssSelector("button.el-button.el-button--primary"));
		return element;
	}

	public static WebElement AgreementCancel(WebDriver driver) {
		// 协议取消
		element = driver.findElement(By.xpath("//button[@class='el-button el-button--default']"));
		// *[@id="app"]/div/div[1]/div/div[3]/div/button[1]/span
		return element;
	}

	public static WebElement Register(WebDriver driver) {
		// 注册
		element = driver.findElement(By.cssSelector("button.el-button.mt20.bg-i-blue.el-button--default"));
		return element;
	}

	public static WebElement messageBox(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, MESSAGE_BOX);
	}

}
