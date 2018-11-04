package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class ResumeElement {

	 private static WebElement element;
	 
	 private static String photo="//i[@class='icon-integral left w86']";
	 private static String temporaryButton="//i[@class='icon-add-favorite']";
	 /**
	  * ȡ���ݴ�
	  */
	 private static String cancelTemporaryButton="//i[@class='icon-cancel-favorite']";
	 /**
	  * ����
	  */
	 private static String exportButton="//i[@class='icon-down-resume']";
	 /**
	  * ת������ť
	  */
	 private static String forwardingReview="//i[@class='icon-turn-judge']";
	 
	 private static String messageboxY="//div[@class='el-message-box__btns']/button[2]";
	 private static String messageboxN="//div[@class='el-message-box__btns']/button[1]";
	 //ӦƸְλ
	 private static String jurnJudgeejob="//div[@class='el-select forward-s']/div/input";
	 
	 private static String judgeeName="//input[@placeholder='���������']";
	 private static String judgeeMailbox="//input[@placeholder='����ٵ�����']";
	 private static String judgeePhoto="//input[@placeholder='����ٵ��ֻ����루�ɿգ�']";
	//��ѡ����
	 private static String turnJudgeeName="//div[@class='el-form-item f-c-ff7 dis-in-b w340']/label";
	 
	 private static String mailNotice="//span[@class='el-checkbox__label'][1]";
	 private static String messageNotice="//span[@class='el-checkbox__label'][2]";
	 //�ʼ�ģ��
	 private static String mailTemplate="//input[@placeholder='��ѡ��֪ͨģ��']";
	 private static String mailTheme="//label[@for='emailInfoList.title']/following-sibling::*[1]/div/input";
	 
	 //ȷ��button
	 private static String sureButoon="//*[@id='app']/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/button[2]/span";
	//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/button[2]/span
	 
	 

	/**
	 * ��iframe
	 */
	 private static String mailContent="//p";
	 
	 
	 public static WebElement getSureButoon(WebDriver driver)throws Exception {
			return CommonAction.getElementByXpath(driver, sureButoon);
		}
	 
	 public static WebElement getmailContent(WebDriver driver) throws Exception {
			return CommonAction.getElementByXpath(driver, mailContent);
		}
	 
	public static WebElement getMailTemplate(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, mailTemplate);
	}
	public static WebElement getMailTheme(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, mailTheme);
	}
	public static WebElement getTurnJudgeeName(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, turnJudgeeName);
	}
	public static WebElement getJurnJudgeejob(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, jurnJudgeejob);
	}
	public static WebElement getJudgeeName(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, judgeeName);
	}
	public static WebElement getJudgeeMailbox(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, judgeeMailbox);
	}
	public static WebElement getJudgeePhoto(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, judgeePhoto);
	}
	public static WebElement getMailNotice(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, mailNotice);
	}
	public static WebElement getMessageNotice(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, messageNotice);
	}
	public static WebElement getPhotoWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, photo);
	}
	/**
	 * �ݴ�Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getTemporaryButtonWebElement(WebDriver driver)throws Exception{
		return CommonAction.getElementByXpath(driver, temporaryButton);
	}
	/**
	 * ȡ���ݴ�Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getCancelTemporaryButtonWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, cancelTemporaryButton);
	}
	/**
	 * ����Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getExportButtonWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, exportButton);
	}
	/**
	 * ת������Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getForwardingReviewWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, forwardingReview);
	}
	
	
	/**
	 * ������Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getmessageboxY(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, messageboxY);
	}
	public static WebElement getmessageboxN(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, messageboxN);
	}
		
	/**
	 * ת������ҳԪ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getTurnJudgeelement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, messageboxY);
	}
	
}
