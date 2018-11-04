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
	  * 取消暂存
	  */
	 private static String cancelTemporaryButton="//i[@class='icon-cancel-favorite']";
	 /**
	  * 导出
	  */
	 private static String exportButton="//i[@class='icon-down-resume']";
	 /**
	  * 转发评审按钮
	  */
	 private static String forwardingReview="//i[@class='icon-turn-judge']";
	 
	 private static String messageboxY="//div[@class='el-message-box__btns']/button[2]";
	 private static String messageboxN="//div[@class='el-message-box__btns']/button[1]";
	 //应聘职位
	 private static String jurnJudgeejob="//div[@class='el-select forward-s']/div/input";
	 
	 private static String judgeeName="//input[@placeholder='评审官姓名']";
	 private static String judgeeMailbox="//input[@placeholder='评审官的邮箱']";
	 private static String judgeePhoto="//input[@placeholder='评审官的手机号码（可空）']";
	//候选人名
	 private static String turnJudgeeName="//div[@class='el-form-item f-c-ff7 dis-in-b w340']/label";
	 
	 private static String mailNotice="//span[@class='el-checkbox__label'][1]";
	 private static String messageNotice="//span[@class='el-checkbox__label'][2]";
	 //邮件模块
	 private static String mailTemplate="//input[@placeholder='请选择通知模板']";
	 private static String mailTheme="//label[@for='emailInfoList.title']/following-sibling::*[1]/div/input";
	 
	 //确认button
	 private static String sureButoon="//*[@id='app']/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/button[2]/span";
	//*[@id="app"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/button[2]/span
	 
	 

	/**
	 * 有iframe
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
	 * 暂存元素
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getTemporaryButtonWebElement(WebDriver driver)throws Exception{
		return CommonAction.getElementByXpath(driver, temporaryButton);
	}
	/**
	 * 取消暂存元素
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getCancelTemporaryButtonWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, cancelTemporaryButton);
	}
	/**
	 * 导出元素
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getExportButtonWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, exportButton);
	}
	/**
	 * 转发评审元素
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getForwardingReviewWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, forwardingReview);
	}
	
	
	/**
	 * 弹出框元素
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
	 * 转发评审页元素
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getTurnJudgeelement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, messageboxY);
	}
	
}
