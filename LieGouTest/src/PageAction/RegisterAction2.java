package PageAction;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.RegisterElement2;

public class RegisterAction2 {
	private static WebDriver driver;  
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
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
	
	 //����driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }
}
