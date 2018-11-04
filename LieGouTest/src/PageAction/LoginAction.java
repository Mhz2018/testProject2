package PageAction;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;

public class LoginAction {
	
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	private static WebDriver driver;  
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	public LoginAction(WebDriver driver){      
		this.driver = driver;   
		}       
	public void Login(String user,String pw) throws Exception 
	{ 
		Thread.sleep(2000);
		LoginElement.userName(driver).sendKeys(user);      
		LoginElement.userPass(driver).sendKeys(pw);      
		LoginElement.loginButton(driver).click();   
		
	} 
	public static void FreeRegistration() {
		LoginElement.FreeRegistration(driver).click();
		
	}
	public static void ForgetPassword() {
		LoginElement.ForgetPassword(driver).click();
		
	}
	
	 //返回driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }
}
