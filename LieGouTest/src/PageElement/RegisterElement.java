package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class RegisterElement {
	private static WebElement element;
	
	//�Ǳ�classʹ�õĶ��� �� public
	public static String registerEnterpriseName = "��ҵ1";//ע�� -- ��ҵ����
	public static String registerUserName = "����";//ע�� -- �û�����
	public static String registerMailBox = "1071516738@qq.com";//ע�� -- ����
	public static String registerMobilePhone = "15217376381";//ע�� -- �绰
	public static String registerPositionName = "����";//ע�� -- ְλ
	
	//��classʹ�õĶ��� public/private ������
	private static String MESSAGE_BOX = "//div[@class='el-message-box__message']";
	private static String USE_NAME = "(//input[@type='text'])[2]";
	private static String EnterpriseName = "input.el-input__inner";

	public static WebElement EnterpriseName(WebDriver driver) {
		// ��ҵ����
		/*
		 * element = driver.findElement(By.cssSelector("input.el-input__inner")); 
		 * return element;
		 */
		return CommonAction.getElementByCss(driver, EnterpriseName);
	}

	public static WebElement UseName(WebDriver driver) throws Exception {
		// ����
		/*
		 * element = driver.findElement(By.xpath("(//input[@type='text'])[2]")); return
		 * element;
		 */
		return CommonAction.getElementByXpath(driver, USE_NAME);
	}

	public static WebElement Mailbox(WebDriver driver) {
		// ����
		element = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		return element;
	}

	public static WebElement MobilePhone(WebDriver driver) {
		// �ֻ���
		element = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		return element;
	}

	public static WebElement PositionName(WebDriver driver) {
		// ְλ
		element = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		return element;
	}

	public static WebElement Agreement(WebDriver driver) throws InterruptedException {
		// Э��
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/form/div[6]/span"));
		// span[@class='fs13 mr5 cp c-i-blue']
		return element;
	}

	public static WebElement AgreementAgree(WebDriver driver) {
		// Э��ͬ��
		element = driver.findElement(By.cssSelector("button.el-button.el-button--primary"));
		return element;
	}

	public static WebElement AgreementCancel(WebDriver driver) {
		// Э��ȡ��
		element = driver.findElement(By.xpath("//button[@class='el-button el-button--default']"));
		// *[@id="app"]/div/div[1]/div/div[3]/div/button[1]/span
		return element;
	}

	public static WebElement Register(WebDriver driver) {
		// ע��
		element = driver.findElement(By.cssSelector("button.el-button.mt20.bg-i-blue.el-button--default"));
		return element;
	}

	public static WebElement messageBox(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, MESSAGE_BOX);
	}

}
