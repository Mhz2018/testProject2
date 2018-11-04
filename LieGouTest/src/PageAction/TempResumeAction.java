package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.CommonElement;
import PageElement.LoginElement;
import PageElement.ResumeElement;
import PageElement.SearchItemElement;
import PageElement.TempPageElement;

public class TempResumeAction {

	// 1�����췽���ķ�����������������ͬ��
	// 2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	// 3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ��������������
	private static WebDriver driver;

	// 1�����췽���ķ�����������������ͬ��
	// 2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	// 3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ��������������
	public TempResumeAction(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * ��������˲ſ� ����ݴ����
	 * 
	 * @param user
	 * @throws Exception
	 */
	public static void tempRe(WebDriver driver) throws Exception
	{
		CommonElement.getLocalTalent(driver).click();
		TempPageElement.getTempStoreWebElement(driver).click();
		System.out.println(TempPageElement.getTempStorenumWebElement(driver).getText());
		//TempPageElement.getTempStorenumWebElement(driver).getText();
	}

	/**
	 * ��ȡ��ϵ��ʽ ���ȷ��
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getPhoto(WebDriver driver) throws Exception
	{
		ResumeElement.getPhotoWebElement(driver).click();
		ResumeElement.getmessageboxY(driver).click();
		assertEquals(SearchItemElement.message(driver).getText(), "��ȡ��ϵ��ʽ�ɹ���");
	}

	/**
	 * ת������ ӦƸְλ������٣�qq����,ȡ���ݴ�
	 * 
	 * @return
	 */
	public static void getTurnJudge(WebDriver driver) throws Exception
	{
		// ResumeElement.getForwardingReviewWebElement(driver).click();
		ResumeElement.getJurnJudgeejob(driver).click();
		CommonAction.getSearchPageDialogElement(driver, "/html/body/div[6]/div[1]/div[1]/ul/li[2]").click();
		;
		// ResumeElement.getJudgeeName(driver).click();
		// CommonAction.getSearchPageDialogElement(driver,
		// "/html/body/div[5]/div[1]/div[1]/ul/li[2]").click();;
		// ResumeElement.getJudgeeMailbox(driver).clear();
		// ResumeElement.getJudgeeMailbox(driver).sendKeys("2015069736@qq.com");
		if (ResumeElement.getMailNotice(driver).isSelected())
		{
			ResumeElement.getMailNotice(driver).click();
			ResumeElement.getSureButoon(driver).click();
		}
		else
		{
			// ResumeElement.getMailNotice(driver).click();
			ResumeElement.getSureButoon(driver).click();
		}

	}

	/**
	 * ȡ���ݴ�
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getCancelStore(WebDriver driver) throws Exception
	{
		TempPageElement.getCancelTempStroeWebElement(driver).click();
		assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "ȡ���ݴ��ϵͳ��ɾ���˼���,�Ƿ������");
		;
		ResumeElement.getmessageboxY(driver).click();
	}

	/**
	 * �ݴ�ҳ��ȡ��ϵ��ʽ��ת������
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getPhotoTurnJudge(WebDriver driver) throws Exception 
	{
	if(TempPageElement.getPictureIdent(driver).getText() == "��Ѽ���")
	{ 
		TempPageElement.getPhotoWebElement(driver).click();
     assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "��ȡ���������ϵ��ʽ�����۳����ֵ�����ȷ����");
   // System.out.println(TempPageElement.getMessageWebElement(driver).getText());
	 TempPageElement.getMessageBoxWebElement(driver).click();
    assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "��ȡ��ϵ��ʽ�ɹ����������������䡣");
	 System.out.println(TempPageElement.getMessageWebElement(driver).getText());
	 TempPageElement.getMessage1WebElement(driver).click();
	 TempPageElement.getForwardingReviewWebElement(driver).click();
	 TempResumeAction.getTurnJudge(driver);
	}
	else
	{
		TempPageElement.getPhotoWebElement(driver).click();
	     assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "�鿴���Ѽ��������۳���Լ��վ������ȷ����");
	     TempPageElement.getMessageBoxWebElement(driver).click();  
	     assertEquals(TempPageElement.getpMessageWebElement(driver).getText(), "��ȡ��ϵ��ʽת���̨���У����1������֪ͨ����");
	}
	}

	/**
	 * �ݴ�ҳ�������
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getimportRume(WebDriver driver) throws Exception 
	{
		TempPageElement.getImportRumeWebElement(driver).click();
		
	}
	
}
