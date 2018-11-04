package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.CommonElement;
import PageElement.LoginElement;
import PageElement.ResumeElement;
import PageElement.SearchItemElement;
import PageElement.TempPageElement;

public class TempResumeAction {

	// 1）构造方法的方法名必须与类名相同。
	// 2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	// 3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。
	private static WebDriver driver;

	// 1）构造方法的方法名必须与类名相同。
	// 2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	// 3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。
	public TempResumeAction(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 点击本地人才库 点击暂存简历
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
	 * 获取联系方式 点击确定
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getPhoto(WebDriver driver) throws Exception
	{
		ResumeElement.getPhotoWebElement(driver).click();
		ResumeElement.getmessageboxY(driver).click();
		assertEquals(SearchItemElement.message(driver).getText(), "获取联系方式成功。");
	}

	/**
	 * 转发评审 应聘职位，评审官，qq邮箱,取消暂存
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
	 * 取消暂存
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getCancelStore(WebDriver driver) throws Exception
	{
		TempPageElement.getCancelTempStroeWebElement(driver).click();
		assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "取消暂存后，系统将删除此简历,是否继续？");
		;
		ResumeElement.getmessageboxY(driver).click();
	}

	/**
	 * 暂存页获取联系方式，转发评审
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getPhotoTurnJudge(WebDriver driver) throws Exception 
	{
	if(TempPageElement.getPictureIdent(driver).getText() == "免费简历")
	{ 
		TempPageElement.getPhotoWebElement(driver).click();
     assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "获取共享简历联系方式，将扣除积分点数，确定吗？");
   // System.out.println(TempPageElement.getMessageWebElement(driver).getText());
	 TempPageElement.getMessageBoxWebElement(driver).click();
    assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "获取联系方式成功，简历放入下载箱。");
	 System.out.println(TempPageElement.getMessageWebElement(driver).getText());
	 TempPageElement.getMessage1WebElement(driver).click();
	 TempPageElement.getForwardingReviewWebElement(driver).click();
	 TempResumeAction.getTurnJudge(driver);
	}
	else
	{
		TempPageElement.getPhotoWebElement(driver).click();
	     assertEquals(TempPageElement.getMessageWebElement(driver).getText(), "查看付费简历，将扣除合约网站点数，确定吗？");
	     TempPageElement.getMessageBoxWebElement(driver).click();  
	     assertEquals(TempPageElement.getpMessageWebElement(driver).getText(), "获取联系方式转入后台运行，结果1分钟内通知您。");
	}
	}

	/**
	 * 暂存页导入简历
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getimportRume(WebDriver driver) throws Exception 
	{
		TempPageElement.getImportRumeWebElement(driver).click();
		
	}
	
}
