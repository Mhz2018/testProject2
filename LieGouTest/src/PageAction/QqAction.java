package PageAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageElement.ForgetPasswordElement;
import PageElement.QqmailboxElement;

public class QqAction {
	private static WebDriver driver; 
	private static WebDriver driver2;  
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	public QqAction(WebDriver driver){      
		this.driver = driver;   
		}  
	
	public static  void qq(String usename,String pass,WebDriver driver2) throws Exception
	{
		//driver2 = new FirefoxDriver();
      //  String baseUrl = "https://mail.qq.com/";  
	//	driver2.get(baseUrl);
		//QqmailboxElement.AccountLogin(driver2);
		QqmailboxElement.Username(driver2).sendKeys(usename);
		QqmailboxElement.Pass(driver2).sendKeys(pass);
		QqmailboxElement.Login(driver2).click();
		Thread.sleep(2000);
		QqmailboxElement.Inbox(driver2).click();
		QqmailboxElement.mail(driver2).click();
		
		QqmailboxElement.mailtext(driver2).getText();
	//	System.out.println(QqmailboxElement.mailtext(driver)).getText());
	//	return QqmailboxElement.mailtext(driver2).getText();
		
		
		//return QqmailboxElement.mailtext(driver).getText();
	}
	public static  String text() throws Exception
	{
	    QqmailboxElement.mailtext(driver2).getText();
	//	System.out.println(QqmailboxElement.mailtext(driver)).getText());
		return QqmailboxElement.mailtext(driver2).getText();
	}
}
