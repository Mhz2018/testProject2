package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.ResumeElement;
import PageElement.SearchItemElement;
import PageElement.TempPageElement;

public class ResumeAction {
	
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	private static WebDriver driver;  
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	public ResumeAction(WebDriver driver){      
		this.driver = driver;   
		} 
//	/**
//	 * ��ȡ��ϵ��ʽ
//	 * ���ȷ��
//	 * @param driver 
//	 * @throws Exception
//	 */
//	public static void getPhoto(WebDriver driver) throws Exception 
//	{ 
//		   ResumeElement.getPhotoWebElement(driver).click();
//		   ResumeElement.getmessageboxY(driver).click();
//		   assertEquals(SearchItemElement.message(driver).getText(),"��ȡ��ϵ��ʽ�ɹ���");
//	} 
//	/**
//	 * ת������
//	 * ӦƸְλ������٣�qq����
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
	
	 //����driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }
}
