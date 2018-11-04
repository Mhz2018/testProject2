package PageAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageElement.ForgetPasswordElement;
import PageElement.LoginElement;
import PageElement.QqmailboxElement;

public class ForgetPasswordAction {
	private static WebDriver driver;  
	private static WebDriver driver2;
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	public ForgetPasswordAction(WebDriver driver){      
		this.driver = driver;   
		}       

	public static void open(String photo,String password,String confirmpassword) throws Exception 
	{       
		
       ForgetPasswordElement.photo(driver).sendKeys(photo);
		ForgetPasswordElement.Password(driver).sendKeys(password);
		ForgetPasswordElement.ConfirmPassword(driver).sendKeys(confirmpassword);
		
		Thread.sleep(2000);
		
	}
	public static void action(String s)
	{
		ForgetPasswordElement.Verification(driver).sendKeys(s);	
		ForgetPasswordElement.Sure(driver).click();
	}

	
}
