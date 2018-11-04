package PageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageAction.ForgetPasswordAction;
import PageAction.LoginAction;
import PageAction.QqAction;

public class ForgetPasswordfailed {
	 private WebDriver driver;
	// private WebDriver driver2;
	  private String baseUrl,base;
	  private String s,handle;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  

	  @BeforeClass(alwaysRun = true)
		public void runBeforClass() throws Exception {		  	
		 // 
		    driver = new FirefoxDriver();
		   
		    baseUrl = "http://web.ailiegou.com/"; 
		  //  base="https://mail.qq.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);	
		     handle = driver.getWindowHandle(); 
	 
	  }
	  @Test(priority=1)
	  public void forgetpassword() throws Exception {
	    //登录
	      Thread.sleep(1000); 
	         // 获取所有页面的句柄，并循环判断不是当前的句柄 
	      LoginAction lo=new LoginAction(driver);
	      lo.ForgetPassword(); 
	      ForgetPasswordAction w = new ForgetPasswordAction(driver);
	      //输入用户名、密码
	      w.open("2015069736@qq.com", "123456", "123456");
           }
	 
	   public String qq() throws Exception {
		  
		   driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		   driver.switchTo().window(tabs.get(0));
		   driver.get("https://mail.qq.com/");
			 // driver.manage().window().maximize();
			  
			 System.out.println(driver.getTitle());
			 Thread.sleep(2000);
			driver.switchTo().frame(0);
		 
	       QqAction.qq("2015069736@qq.com", "aabb123456",driver);
	       Thread.sleep(3000);
	       driver.getTitle();
	       driver.switchTo().frame("mainFrame");
	        s= QqAction.text();
	        System.out.println(driver.getTitle());
	        driver.close();
	        return s;
	  }
	  @Test(priority=2)
	  public void assert1() throws Exception {
		  
		String   s1= qq();
		  ForgetPasswordAction.action(s1);
	      assertEquals(driver.findElement(By.xpath("//div[@class='el-message-box__message']/p")).getText(),"密码修改成功，可以重新登录！");  
	
	  }
	  
	  
	  
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	   // driver2.quit();
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  
	  }
}
