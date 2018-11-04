package PageAction;

import org.openqa.selenium.WebDriver;

import PageElement.RegisterElement;

public class RegisterAction {
	private WebDriver driver;

	// 1）构造方法的方法名必须与类名相同。
	// 2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	// 3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。
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

	// 返回driver
	public WebDriver ReturnDriver() {
		return this.driver;
	}
}
