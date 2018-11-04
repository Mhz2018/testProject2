package PageAction;

import org.openqa.selenium.WebDriver;

import PageElement.RegisterElement;

public class RegisterAction {
	private WebDriver driver;

	// 1�����췽���ķ�����������������ͬ��
	// 2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	// 3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ��������������
	public RegisterAction(WebDriver driver) {
		this.driver = driver;
	}

	public void register() throws Exception {
		register(RegisterElement.registerEnterpriseName, RegisterElement.registerUserName,
				RegisterElement.registerMailBox, RegisterElement.registerMobilePhone,
				RegisterElement.registerPositionName);
	}

	public void register(String enterprisename, String usename, String mailbox, String mobilephone,
			String positionname) throws Exception {
		RegisterElement.EnterpriseName(driver).sendKeys(enterprisename);
		RegisterElement.UseName(driver).sendKeys(usename);
		RegisterElement.Mailbox(driver).sendKeys(mailbox);
		RegisterElement.MobilePhone(driver).sendKeys(mobilephone);
		RegisterElement.PositionName(driver).sendKeys(positionname);

	}

	public void click() throws Exception {
		Thread.sleep(2000);
		RegisterElement.Agreement(driver).click();
		Thread.sleep(2000);
		RegisterElement.AgreementAgree(driver).click();
		Thread.sleep(2000);
		RegisterElement.Register(driver).click();
	}

	// ����driver
	public WebDriver ReturnDriver() {
		return this.driver;
	}
}
