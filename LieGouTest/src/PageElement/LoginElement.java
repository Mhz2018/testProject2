package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElement {

	 private static WebElement element;
		
	 public static WebElement userName(WebDriver driver) throws Exception{
		 //�û���  
		 Thread.sleep(2000);
		 element = driver.findElement(By.cssSelector("input.el-input__inner"));       
		 return element;   
		 }
	 
	 public static WebElement userPass(WebDriver driver) throws Exception{
		 //����    
		 Thread.sleep(2000);
		 element = driver.findElement(By.xpath("//input[@type='password']"));       
		 return element;   
		 }
	 
	 public static WebElement loginButton(WebDriver driver){
		 //��¼����        
		 element = driver.findElement(By.xpath("//button[@type='button']"));        
		 return element;    
		 }
	 
	 public static WebElement FreeRegistration(WebDriver driver){
		 //���ע��        
		 element = driver.findElement(By.xpath("//a[@href='/sign-in']"));        
		 return element;    
		 }
	 public static WebElement ForgetPassword(WebDriver driver){
		 //��������        
		 element = driver.findElement(By.xpath("//a[@href='/forgot']"));        
		 return element;    
		 }
	 
}
