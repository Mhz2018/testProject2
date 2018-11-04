package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElement2 {
	 private static WebElement element;
		
	 public static WebElement EnterpriseName(WebDriver driver){
		 //企业名称       
		 element = driver.findElement(By.cssSelector("input.el-input__inner"));       
		 return element;   
		 }
	 public static WebElement UseName(WebDriver driver){
		 //姓名       
		 element = driver.findElement(By.xpath("(//input[@type='text'])[2]"));       
		 return element;   
		 }
	 
	 public static WebElement Mailbox(WebDriver driver){
		 //邮箱     
		 element = driver.findElement(By.xpath("(//input[@type='text'])[3]"));       
		 return element;   
		 }
	 public static WebElement MobilePhone(WebDriver driver){
		 //手机号       
		 element = driver.findElement(By.xpath("(//input[@type='text'])[4]"));       
		 return element;   
		 }
	 public static WebElement PositionName(WebDriver driver){
		 //职位       
		 element = driver.findElement(By.xpath("(//input[@type='text'])[5]"));       
		 return element;   
		 }
	 public static WebElement Agreement(WebDriver driver) throws InterruptedException{
		 //协议 
		 Thread.sleep(2000);
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/form/div[6]/span"));  
		//span[@class='fs13 mr5 cp c-i-blue']
		 return element;   
		 }
	 public static WebElement AgreementAgree(WebDriver driver){
		 //协议同意       
		 element = driver.findElement(By.cssSelector("button.el-button.el-button--primary"));       
		 return element;   
		 }
	 public static WebElement AgreementCancel(WebDriver driver){
		 //协议取消      
		 element = driver.findElement(By.xpath("//button[@class='el-button el-button--default']")); 
		//*[@id="app"]/div/div[1]/div/div[3]/div/button[1]/span
		 return element;   
		 }
	 public static WebElement Register(WebDriver driver){
		 //注册      
		 element = driver.findElement(By.cssSelector("button.el-button.mt20.bg-i-blue.el-button--default"));       
		 return element;   
		 }
	 
}
