package PageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageAction.CommonAction;

public class TempPageElement {
	private static WebElement element;
	private static String tempStore="//ul[@class='el-menu']/li[@role='menuitem'][1]";
	private static String wholeStore="//ul[@class='el-menu']/li[@role='menuitem'][2]";
	private static String beTreated="//ul[@class='el-menu']/li[@role='menuitem'][3]";
	private static String tempStorenum="//span[@class='right c-blue'][1]";
	private static String jobPosition="//div[@class='tw-date col-195 el-col el-col-24'][1]";
	private static String collectDate="//div[@class='tw-date col-195 el-col el-col-24'][2]";
	private static String updateDate="//div[@class='tw-date col-195 el-col el-col-24'][3]";
	private static String keys="//input[@class='el-input__inner' and @placeholder='������ؼ���']";
	private static String allCheck="//tr[@class='']/th[1]";
	private static String joinPk="";
	private static String name="//button[@class='el-button c-blue button-detail h25 el-button--default']/span[1]";
	
	private static String pictureIdent="//table/tbody/tr[4]/td[2]/div/div/span";
	
	private static String photo="//table/tbody/tr[1]/td[4]/div/div[2]/button";
	private static String forwardingReview="//table/tbody/tr[1]/td[4]/div/div[3]/button";
	private static String cancelTempStroe="//table/tbody/tr[1]/td[4]/div/div[4]/button";
	
    private static String importRume="//i[@class='icon ai-import-resume iconfont mr5']";
    private static String importRumefrom="//div[contains(text(),'ӦƸְλ��')]/following-sibling::div[1]/div/input";
    private static String importRumeto="";
    private static String importRumenum="//span[@class='tip']";
    
    private static String importRumeButoonY="//span[contains(text(),'�ϴ����')]";
    private static String importRumeButoonN="//span[contains(text(),'�������')]";
    

	private static String dropdownBox="/html/body/div[5]/div[1]/div[1]/ul/li";
	private static String startSearch="//div[@class='el-input-group__append']/button/span";
	/**
	 * ��ʼ����
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getStartSearchWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, startSearch);
	}
	/**
	 * �������Ԫ��
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getImportRumeWebElement(WebDriver driver) throws Exception  {
		
		return CommonAction.getElementByXpath(driver, importRume);
	}
	
	public static WebElement getPictureIdent(WebDriver driver) throws Exception {
		
		return CommonAction.getElementByXpath(driver, pictureIdent);
	}
	/**
	 * ȫ��
	 */
	public static WebElement getWholeStoreWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, wholeStore);
	}
	public static WebElement getKeysWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, keys);
	}
	/**
	 * ������
	 */
	public static WebElement getBeTreatedWebElement(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, beTreated);
	}
	/**
	 * �ݴ�
	 * @param driver
	 * @return
	 */
	public static WebElement getTempStoreWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, tempStore);
	}
	/**
	 * �ݴ����
	 * @param driver
	 * @return
	 */
	public static WebElement getTempStorenumWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, tempStorenum);
	}
	/**
	 * ģ������-������
	 * @param driver
	 * @return
	 */
	public static List<WebElement> getDropdownBoxsWebElements(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpaths(driver, dropdownBox);
	}
	
	/**
	 * ӦƸְλ
	 * @param driver
	 * @return
	 */
	public static WebElement getJobPositionWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, jobPosition);
	}
	
	/**
	 * �ռ�ʱ��
	 * @param driver
	 * @return
	 */

	public static WebElement getCollectDateWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, collectDate);
	}
	/**
	 * ����ʱ��
	 * @param driver
	 * @return
	 */

	public static WebElement getUpdateDateWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, updateDate);
	}
	/**
	 * ȫѡ��ť
	 * @param driver
	 * @return
	 */

	public static WebElement getAllCheckWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, allCheck);
	}
	/**
	 * ����pk
	 * @param driver
	 * @return
	 */

	public static WebElement getJoinPkWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, joinPk);
	}
	/**
	 * ������
	 * @param driver
	 * @return
	 */

	public static WebElement getnameWebElement(WebDriver driver) throws Exception{
		Thread.sleep(2000);
		return CommonAction.getElementByXpath(driver, name);
	}
	/**
	 * ��ȡ��ϵ��ʽ
	 * @param driver
	 * @return
	 */
	public static WebElement getPhotoWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, photo);
	}
	/**
	 * ת������
	 * @param driver
	 * @return
	 */
	public static WebElement getForwardingReviewWebElement(WebDriver driver) throws Exception{
		return CommonAction.getElementByXpath(driver, forwardingReview);
	}

	/**
	 * ȡ���ݴ�
	 * @param driver
	 * @return
	 */
	public static WebElement getCancelTempStroeWebElement(WebDriver driver)throws Exception {
		return CommonAction.getElementByXpath(driver, cancelTempStroe);
	}
	/**
	 * ģ������������
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement getDropdownBoxWebElement(WebDriver driver) throws Exception{
		 //����״̬-��ְ,���뻻
//		Thread.sleep(2000);
		
		element=CommonAction.getSearchPageDialogElement(driver,"/html/body/div[3]/div/div/ul/li[3]");
		System.out.println(element); 
		 return element;   
	}
	/**
	 * �ݴ�ҳ -�����б�
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement searchlistWebElement(WebDriver driver) throws Exception
	{
		CommonAction.getElementByXpaths(driver, "//div/table/tbody/tr[1]");
		
		return element;
	}
	/**
	 * ������-ȷ�ϻ�ȡ��
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getMessageBoxWebElement(WebDriver driver) throws Exception
	{
				
		return CommonAction.getElementByXpath(driver, "//div[@class='el-message-box']/div[3]/button[2]");
		
	}
	/**
	 * ������-ȷ��
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getMessage1WebElement(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);		
		return CommonAction.getElementByXpath(driver, "//div[@class='el-message-box']/div[3]/button[2]");
	}
	/**
	 * ������-����
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getMessageWebElement(WebDriver driver) throws Exception
	{
				
		return CommonAction.getElementByXpath(driver, "//div[@class='el-message-box']/div[2]/div[2]/p");
	}
	
	/**
	 * p��ʾ
	 * @param driver
	 * @return
	 * @throws Exception 
	 */
	public static WebElement getpMessageWebElement(WebDriver driver) throws Exception
	{
				
		return CommonAction.getElementByXpath(driver, "//p[@class='el-message__content']");
	}
}
