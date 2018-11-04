package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QqmailboxElement {
	private static WebElement element;
	private static String url="https://mail.qq.com/";
	
	 public static WebDriver AccountLogin(WebDriver driver2){
////	    	//�л����˺������¼    
            element=(WebElement) driver2.switchTo().frame("mainframe");
//			 
			 return (WebDriver) element;
	    }
	 public static WebElement Username(WebDriver driver2){
	    	//�˺�        
			 element = driver2.findElement(By.xpath("//*[@id='u']"));        
			 return element;
	    }
	 public static WebElement Pass(WebDriver driver2){
	    	//����        
			 element = driver2.findElement(By.xpath("//*[@id='p']"));        
			 return element;
	    }
	 public static WebElement Login(WebDriver driver2){
	    	//��¼       
			 element = driver2.findElement(By.xpath("//*[@id='login_button']"));        
			 return element;
	    }
	 public static WebElement Inbox(WebDriver driver2){
	    	//�ռ���       
			 element = driver2.findElement(By.xpath("//a[@id='folder_1']/b"));        
			 return element;
	    }
	 public static WebElement mail(WebDriver driver2){
	    	//�׷��ʼ�      
		     driver2.switchTo().frame("mainFrame");
			 element = driver2.findElements(By.xpath("//span[@t='u']")).get(0);        
			 return element;
	    }
//	 public static void frame(WebDriver driver) throws Exception
//	 {
//		 Thread.sleep(2000);
//		 driver.switchTo().frame("mainFrame");
//		 System.out.println("1");
//		 
//	 }
	 public static WebElement mailtext(WebDriver driver) {
	    	//�׷��ʼ�����    
		   element=driver.findElement(By.xpath("//*[@id='mailContentContainer']"));    
		    String s= element.getText();
		    System.out.println("2");
			 return element;
	    }
	
}
