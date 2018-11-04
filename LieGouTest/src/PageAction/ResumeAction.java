package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.ResumeElement;
import PageElement.SearchItemElement;
import PageElement.TempPageElement;

public class ResumeAction {
	
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	private static WebDriver driver;  
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	public ResumeAction(WebDriver driver){      
		this.driver = driver;   
		} 
//	/**
//	 * 获取联系方式
//	 * 点击确定
//	 * @param driver 
//	 * @throws Exception
//	 */
//	public static void getPhoto(WebDriver driver) throws Exception 
//	{ 
//		   ResumeElement.getPhotoWebElement(driver).click();
//		   ResumeElement.getmessageboxY(driver).click();
//		   assertEquals(SearchItemElement.message(driver).getText(),"获取联系方式成功。");
//	} 
//	/**
//	 * 转发评审
//	 * 应聘职位，评审官，qq邮箱
//	 * @return
//	 */
//	public static void getTurnJudge(WebDriver driver) throws Exception 
//	{ 
//		   ResumeElement.getForwardingReviewWebElement(driver).click();
//		   ResumeElement.getJurnJudgeejob(driver).click();
//		   CommonAction.getSearchPageDialogElement(driver, "/html/body/div[6]/div[1]/div[1]/ul/li[2]").click();;
//		   ResumeElement.getJudgeeName(driver).click();
//		   CommonAction.getSearchPageDialogElement(driver, "/html/body/div[5]/div[1]/div[1]/ul/li[2]").click();;
//		   ResumeElement.getJudgeeMailbox(driver).clear();
//		   ResumeElement.getJudgeeMailbox(driver).sendKeys("2015069736@qq.com");
//		   ResumeElement.getMailNotice(driver).click();
//		   ResumeElement.getSureButoon(driver).click();
//	   
//	} 
//	
	
	 //返回driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }
}
