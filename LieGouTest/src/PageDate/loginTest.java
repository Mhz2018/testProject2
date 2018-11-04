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
	WebDriver webdriver = new FirefoxDriver();//注意，一定要将该行放在此处，
	                                         //如果放在beforeTest方法中会导致其他方法执行时报空指针异常
	@Parameters({"url"})
	@BeforeTest
	public void beforeTest(String url) {
		login = new LoginAction(webdriver);//初始化类
		webdriver.get(url);
		webdriver.manage().window().maximize();
	}
	
	@Parameters({"username,password"})
	@Test(priority=1)
	public void login(String username,String password)throws Exception {//登录
		login.Login(username, password);
	}
	
	 @AfterTest
	  public void afterTest() {
		 webdriver.close();
  }
} 

