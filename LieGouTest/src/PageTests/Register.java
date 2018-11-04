package PageTests;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageAction.LoginAction;
import PageAction.RegisterAction;

public class Register {
	 private WebDriver driver;
	 private WebDriver driver2;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
		public void runBeforClass() throws Exception {		  	
		 // 
		    driver = new FirefoxDriver();
		    baseUrl = "http://192.168.0.110:81/"; 
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		    driver.manage().window().maximize();
	 
	  }
	  @Test
	  public void register() throws Exception {
	    //登录
	      Thread.sleep(1000);
	      LoginAction la = new LoginAction(driver);
	      la.FreeRegistration(); 
	      Thread.sleep(2000);
	      RegisterAction la2 = new RegisterAction(driver);
	      
	      //输入用户名、密码
	      la2.register("企业1","世界","1071516738@qq.com", "15217376381", "助理"); 
	      la2.click();
	       Thread.sleep(2000);
	    //断言登录成功
	       assertEquals(driver.findElement(By.xpath("//div[@class='el-message-box__message']")).getText(),"已经注册成功，密码会稍后发送到您的邮箱，请耐心等待！");
	       System.out.println("已发送，注意查收");
	  }
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	   // driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
