package PageDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import PageAction.LoginAction;
 
public class loginTest {
	
	LoginAction login = null;
	WebDriver webdriver = new FirefoxDriver();//ע�⣬һ��Ҫ�����з��ڴ˴���
	                                         //�������beforeTest�����лᵼ����������ִ��ʱ����ָ���쳣
	@Parameters({"url"})
	@BeforeTest
	public void beforeTest(String url) {
		login = new LoginAction(webdriver);//��ʼ����
		webdriver.get(url);
		webdriver.manage().window().maximize();
	}
	
	@Parameters({"username,password"})
	@Test(priority=1)
	public void login(String username,String password)throws Exception {//��¼
		login.Login(username, password);
	}
	
	 @AfterTest
	  public void afterTest() {
		 webdriver.close();
  }
} 

