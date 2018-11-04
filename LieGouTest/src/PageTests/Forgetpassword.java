package PageTests;

import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Forgetpassword {
  private WebDriver driver,driver2;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
   driver = new FirefoxDriver();
    
    baseUrl = "http://web.ailiegou.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize(); 
  }

 @Test
  public void testWangjimima() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.xpath("//a[@class='left c-i-blue cp']")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("2015069736aa@qq.com");
    driver.findElement(By.xpath("//input[@type='password']")).clear();
    //验证码
    driver.findElement(By.xpath("//*[@id='app']/div/div[2]/form/div[2]/div/div/div/span")).click();
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("123456");
    Thread.sleep(6000);
    String m=Verification();
    Thread.sleep(2000);
   // driver.switchTo().window();
  //*[@id="app"]/div/div[2]/form/div[2]/div/div[1]/input
    driver.findElement(By.xpath("//*[@id='app']/div/div[2]/form/div[2]/div/div[1]/input")).sendKeys(m);
  //*[@id="app"]/div/div[2]/form/div[2]/div/div/div/span
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("span.cp")).click();
    
  }
  
//@Test
  private String Verification() throws Exception {
	// TODO Auto-generated method stub
	  driver2=new FirefoxDriver();
	  driver2.get("https://mail.qq.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000); 
	  driver2.switchTo().frame(0);
	  driver2.findElement(By.xpath("//*[@id='switcher_plogin']")).click();
	  driver2.findElement(By.id("u")).clear();
	    driver2.findElement(By.id("u")).sendKeys("2015069736@qq.com");
	    driver2.findElement(By.id("p")).clear();
	    driver2.findElement(By.id("p")).sendKeys("aabb123456");
	    driver2.findElement(By.id("login_button")).click();
	    Thread.sleep(2000);
	    driver2.findElement(By.xpath("//a[@id='folder_1']")).click();
	    
	  //*[@id="folder_1"]
	    Thread.sleep(3000);
	    
	    driver2.switchTo().frame("mainFrame");	    
	  //*[@id="mainFrame"]
	    Thread.sleep(3000);
	  //*[@id="div_showtoday"]/table[1]/tbody/tr/td[3]/table/tbody/tr/td[1]/nobr/span
	    driver2.findElements(By.xpath("//span[@t='u']")).get(0).click();
	    
	    String mm= driver2.findElement(By.xpath("//*[@id='mailContentContainer']")).getText();
	    String jieguo = mm.substring(mm.indexOf("证码为:")+4,mm.indexOf("证码为:")+10);
	   // mm.substring(4, 8);
	   System.out.println(jieguo);
	    driver2.close();
	    
	  return jieguo;
}

@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    //driver.quit();
	//driver2.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

 
}

