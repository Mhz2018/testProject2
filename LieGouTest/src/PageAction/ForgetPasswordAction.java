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
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
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
