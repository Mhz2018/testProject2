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
import CommonObject.Common2;
import PageAction.LoginAction;
import PageElement.LoginElement;

public class Login {
	
		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeClass(alwaysRun = true)
			public void runBeforClass() throws Exception {		  	
			 // 
			    driver = new FirefoxDriver();
			    baseUrl = "http://192.168.0.150:81/"; 
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.get(baseUrl);	
		 
		  }
		  @Test
		  public void login() throws Exception {
		    //��¼
		      Thread.sleep(1000);
			  LoginAction la = new LoginAction(driver);
		      //�����û���������
		      la.Login("tangboanan@qq.com", "123456"); 
		       Thread.sleep(2000);
		    //���Ե�¼�ɹ�
		     assertEquals(driver.findElement(By.cssSelector("div.el-submenu__title")).getText(),"����");  
		  }
		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		   // driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  
		  }}
