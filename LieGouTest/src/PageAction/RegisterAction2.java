package PageAction;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.RegisterElement2;

public class RegisterAction2 {
	private static WebDriver driver;  
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	public RegisterAction2(WebDriver driver){      
		this.driver = driver;   
		}       
	public static void Register(String enterprisename,String usename,String mailbox,String mobilephone,String positionname)  
	{       
		RegisterElement2.EnterpriseName(driver).sendKeys(enterprisename);      
		RegisterElement2.UseName(driver).sendKeys(usename); 
		RegisterElement2.Mailbox(driver).sendKeys(mailbox);
		RegisterElement2.MobilePhone(driver).sendKeys(mobilephone);
		RegisterElement2.PositionName(driver).sendKeys(positionname);	
		
	}  
	public static void Click() throws Exception
	{
		Thread.sleep(2000);
		RegisterElement2.Agreement(driver).click();
		Thread.sleep(2000);
		RegisterElement2.AgreementAgree(driver).click();
		Thread.sleep(2000);
		RegisterElement2.Register(driver).click();
	}
	
	 //返回driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }
}
