package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordElement {
	private static WebElement element;
    
    public static WebElement photo(WebDriver driver){
    	//����/����       
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/form/div[1]/div/div[1]/input"));        
		 return element;
    }
    public static WebElement Verification(WebDriver driver){
    	//��֤��        
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/form/div[2]/div/div[1]/input"));        
		 return element;
    }
    public static WebElement Password(WebDriver driver){
    	//����        
		 element = driver.findElement(By.xpath("//input[@type='password']"));        
		 return element;
    }
    public static WebElement ConfirmPassword(WebDriver driver){
    	//ȷ������      
		 element = driver.findElement(By.xpath("(//input[@type='password'])[2]"));        
		 return element;
    }
    public static WebElement Sure(WebDriver driver){
    	//ȷ�ϰ�ť     
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/form/button"));        
		 return element;
    }
    
    
    
    
    
    
}
