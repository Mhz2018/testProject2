package PageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageAction.CommonAction;

public class SearchItemElement {
	private static WebElement element,element1;
	private static List<WebElement> element2;
	private static  String chooseedu="//ul[@id='edu']/li[@class='active']";
	private static  String chooseworkExp="//ul[@id='workExp']/li[@class='active']";
	
	public static WebElement getChooseedu(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, chooseedu);
	}

	public static WebElement getChooseworkExp(WebDriver driver) throws Exception {
		return CommonAction.getElementByXpath(driver, chooseworkExp);
	}

	public static WebElement SearchList(WebDriver driver) throws InterruptedException{
		 //����������
		Thread.sleep(2000);
		element= driver.findElement(By.xpath("//ul[@class='el-menu-demo el-menu']/li[2]"));       
		 return element;   
		 }
	
	public static WebElement Keyword(WebDriver driver){
		 //�ؼ���      
		 element = driver.findElement(By.cssSelector("input.el-input__inner"));       
		 return element;   
		 }
	public static WebElement Anyey(WebDriver driver){
		 //��һ�ؼ���       
		 element = driver.findElements(By.xpath("//span[@class='el-checkbox__label']")).get(0);       
		 return element;   
		 }
	/**
	 * //������ť   
	 */
	public static WebElement SearchButton(WebDriver driver){
		 
		 element = driver.findElement(By.xpath("//span[contains(text(), '��������')]"));       
		 return element;   
		 }
	public static WebElement CommonSearch(WebDriver driver){
		 //��������  
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span"));       
		 return element;   
		 }
	/**
	 * ����ְҵ
	 * @param driver
	 * @return
	 */
	public static WebElement IntentionalProfession(WebDriver driver){   
		 element = driver.findElement(By.xpath("//div[@class='cont-div']/span"));       
		 return element;   
		 }
	/**
	 * ����ְҵ-1��
	 * @param driver
	 * @return
	 */
	public static WebElement IntentionalProfession1(WebDriver driver){
		 //����ְҵ -1��  
		 element = driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div/div[2]/div[4]/div/div[2]/ul/li/ul/li/ul/li[13]"));       
		 return element;   
		 }
	/**
	 * ����ְҵ-2��
	 * @param driver
	 * @return
	 */
	public static WebElement IntentionalProfession2(WebDriver driver){
		 //   
		 element = driver.findElement(By.xpath("(//button[@type='button'])[13]"));       
		 return element;   
		 }
	
	/**
	 * ����ȷ�ϰ�ť
	 * @param driver
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	
	public static WebElement IntentionalProfessionsure(WebDriver driver) throws Exception{  
		Thread.sleep(2000);
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[4]/div/div[2]/footer/button[2]"));
		
		 return element;   
		 }
	
	public static WebElement DesiredPlace(WebDriver driver) throws Exception{
		 //����������   
		Thread.sleep(1000);
		 element = driver.findElement(By.id("expWork"));
		 return element;   
		 }
	/**
	 * ��ְ��ҵ
	 * @param driver
	 * @return
	 */
	public static WebElement TenureEnterprise(WebDriver driver){
		 //  
		 element = driver.findElement(By.xpath("//input[@placeholder='��������ְ��ҵ']"));       
		 return element;   
		 }
	public static WebElement NewestTenureEnterprise(WebDriver driver){
		 //�����ְ��ҵ  
		 element = driver.findElement(By.xpath("//input[@placeholder='��������ְ��ҵ']"));       
		 return element;   
		 }
	public static WebElement UpdateTime(WebDriver driver) throws InterruptedException{
		 //����ʱ��  
		Thread.sleep(1000);
		 element = driver.findElement(By.xpath("//input[@placeholder='����']"));       
		 return element;   
		 }
	public static WebElement UpdateTime1(WebDriver driver, int udt2) throws InterruptedException{
		 //����ʱ�� 1 
		Thread.sleep(1000);
		String xPath = "/html/body/div[2]/div[1]/div[1]/ul/li";
		element2 = CommonAction.getSearchPageDialogElements(driver, xPath);	
		return element2.get(udt2);
		 }
	/*
	 * //չ��
	 **/ 
	public static WebElement Openbutton(WebDriver driver) throws Exception{
		 Thread.sleep(2000);
		 element = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[1]/div[6]/button"));       
		 return element;   
		 }
	/**
	 * ��ҵ-�Զ���
	 * @param driver
	 * @return
	 */
	public static WebElement IndustryCustom(WebDriver driver){
		  
		 element = driver.findElement(By.xpath("//*[@id='industry']/li[2]"));       
		 return element;   
		 }
	/**
	 * ��ҵ-���
	 * @param driver
	 * @return
	 */
	public static WebElement IndustryRecent(WebDriver driver) throws Exception{
		   
		Thread.sleep(2000);
		 element= driver.findElement(By.xpath("//*[@id='industry']/li[3]/label/span[2]"));
		
		//*[@id="industry"]/li[2]
		//div[@class='show-industry-md-ri']
		 //�����
		return element;  
	 }
	/**
	 * ��ҵ�б�1
	 * @param driver
	 * @param i
	 * @param j
	 * @return
	 * @throws Exception
	 */
	public static WebElement IndustryCuston1(WebDriver driver,int i,int j) throws Exception
	{
		//�����
		Thread.sleep(3000);
		driver.findElements(By.xpath("//div[@class='show-industry-md-ri']")).get(i).click();
		//ѡ���������
		element=driver.findElements(By.xpath("//ul[@class='show-industry-md-le roll show']/li")).get(j);
		
	    return element;
}
	/**
	 * ��ҵ�б�ȷ�ϰ�ť
	 * @param driver
	 * @return
	 * @throws Exception
	 */
		public static WebElement IndustryCustonsure(WebDriver driver) throws Exception
		{
			element=driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/footer/button[2]/span"));
			return element;
		}
	/**
	 * ��ҵ-����
	 * @param driver
	 * @return
	 */
	public static WebElement IndustryNolimit(WebDriver driver){
		    
		 element = driver.findElement(By.xpath("//ul[@id='industry']/li[1]"));       
		 return element;   
		 }
	public static WebElement ExperienceCcustom(WebDriver driver){
			 //����-�Զ���   
			 element = driver.findElement(By.xpath(""));       
			 return element;   
		
	}
	/**
	 * ��������
	 * @param driver
	 * @return
	 */
	public static List<WebElement> experience(WebDriver driver){
			 
			 element2 = driver.findElements(By.xpath("//li[@name='workExp']"));       
			 return element2;   
			 }
	/**
	 * ���⾭��
	 */
	public static WebElement overseas(WebDriver driver){
		    
		 element = driver.findElement(By.xpath("//div[@class='open-options-div']/ul[@id='workExp']/li/label/span[@class='el-checkbox__label']"));       
		 return element;   
		 }
	
	
	/**
	 * ѧ��-�Զ���
	 */
	public static WebElement Educationustom(WebDriver driver){  
			 element = driver.findElement(By.xpath(""));       
			 return element;   
		}
	/**
	 * ѧ��
	 */
	public static List<WebElement> Education(WebDriver driver){
		 element2 = driver.findElements(By.xpath("//li[@name='edu']"));       
		 return element2;   
	}
	/**
	 *  ��ѧ��985���б�
	 */
	public static List<WebElement> Highlyeducated(WebDriver driver){
		 element2 = driver.findElements(By.xpath("//div[@class='open-options-div']/ul[@id='edu']/li/label/span[@class='el-checkbox__label']"));       
		 return element2;   
	}
	//div[@class='open-options-div']/ul[@id='workExp']/li/label/span[@class='el-checkbox__label']
	
	/**
	 *����н��
	 */
	public static List<WebElement> SalaryExpectation(WebDriver driver){
			 element2 = driver.findElements(By.xpath("//li[@name='salary']"));       
			 return element2;   
		}
	
	/**
	 *���䰴ť
	 */
	public static WebElement age(WebDriver driver){
		 //����   
		 element = driver.findElement(By.xpath("//input[@placeholder='����']"));       
		 return element;   
	}
	/**
	 *����2
	 */
	public static List<WebElement> age1(WebDriver driver) throws Exception{
		 //   
		Thread.sleep(1000);
		 element2 = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper hide-drop-down-empty select-age']/div[1]/div[1]/ul/li"));    
		 return element2;   
	}
	/**
	 *�Ա�ť
	 */
	public static WebElement sex(WebDriver driver){
		 element = driver.findElement(By.xpath("//input[@placeholder='�Ա�']"));       
		 return element;   
	}
	/**
	 *�Ա�
	 */
	public static List<WebElement> sex1(WebDriver driver) throws Exception{
		Thread.sleep(1000);
		// element = driver.findElement(By.xpath("//div[@class='el-select-dropdown el-popper'and @x-placement='bottom-start' ]/div/div/ul/li[2]"));
		//div[@class='el-select-dropdown el-popper'and @x-placement='bottom-start' ]/div/div/ul/li[2]
		element2=CommonAction.getSearchPageDialogElements(driver, "/html/body/div[2]/div[1]/div[1]/ul/li");
		 
		return element2;   
	}
	
	/**
	 *��ס��
	 */
		
	public static WebElement Place(WebDriver driver){
		    
		 element = driver.findElement(By.id("nowPlace"));       
		 return element;   
	}

	/**
	 * ����
	 */
	public static WebElement Registered(WebDriver driver){
		    
		 element = driver.findElement(By.id("nativePlace")); 
		 return element;   
	}
	/**
	 * ����״̬ 
	 */
	public static WebElement Jobtatus1(WebDriver driver){
		 element = driver.findElement(By.xpath("//input[@placeholder='��ְ״̬']"));       
		 return element;   
	}
	public static List<WebElement> Jobtatus2(WebDriver driver) throws Exception{
		 //����״̬-��ְ,���뻻
		Thread.sleep(2000);
		
		element2=CommonAction.getSearchPageDialogElements(driver,"/html/body/div[2]/div[1]/div[1]/ul/li");
		// element2 = driver.findElements(By.xpath()); 
		 return element2;   
	}
	
	public static WebElement School(WebDriver driver){
		 //ѧУ   
		 element = driver.findElement(By.xpath("//input[@placeholder='��ҵԺУ']"));       
		 return element;   
	}
	public static WebElement major(WebDriver driver){
		 //רҵ  
		 element = driver.findElement(By.xpath("//input[@placeholder='��ѧרҵ']"));       
		 return element;   
	}
	/**
	 * �ݴ����
	 * @param driver
	 * @return
	 */
	public static WebElement TemporaryResumes(WebDriver driver){
		 //  
		 element = driver.findElements(By.xpath("//button[@class='el-button el-button--default']/span")).get(1);       
		 return element;   
	}
	/**
	 * �鿴���� 
	 * @param driver
	 * @return
	 */
	public static WebElement ViewDetails(WebDriver driver){
		 
		 element = driver.findElements(By.xpath("//button[@class='el-button el-button--default']/span")).get(2);       
		 return element;   
	}

	// ��ѡ����
	public static List<WebElement> SelectedConditions(WebDriver driver) {

		element2 = driver
				.findElements(By
						.xpath("//div[@id='app']/div/div[2]/div/div/div[2]/div[5]/div[2]/span"));
		return element2;
	}

	/**
	 * ���浽������
	 */ 
	public static WebElement Saveto(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//i[@class='icon-save-search']"));
		return element;
	}
	/**
	 * ����������
	 */
	public static List<WebElement> Savenum(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		element2 = driver.findElements(By
				.xpath("//span[@class='pr20 max600 nowrap left']"));
	//	"//span[@class='el-tag search-tag']"));
		//ul[@class='el-dropdown-menu el-popper search-r-drop']/div/li
		return element2;
	}

	/**
	 * ����������ť
	 */
	public static WebElement Frequentlyusedsearch(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	/**
	 * ����ɹ���ʾ��
	 */
	public static WebElement message(WebDriver driver) throws Exception {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement wl = wait.until(new ExpectedCondition<WebElement>() {  
		            @Override  
		            public WebElement apply(WebDriver d) {  
		                return d.findElement(By.xpath("//p[@class='el-message__content']"));  
		            }  
		        });
		element = driver.findElement(By.xpath("//p[@class='el-message__content']"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	/**
	 * ɾ������������������
	 */
	public static WebElement delete(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElements(By.xpath("//button[@class='el-button icon-o-delete cp danger drop-del left el-button--default']")).get(0);
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	// *[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span

	/**
	 * ��ʾ��ʾ�ﰴť
	 */
	public static WebElement messageY(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//span[contains(text(),'֪����')]"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	
	/**
	 * ��ʾ��ȷ�ϰ�ť
	 */
	public static WebElement message2(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//div[@class='el-message__content']/p"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	/**
	 * ����ť
	 */
	public static WebElement Takeup(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//i[@class='el-icon-arrow-up']"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	/**
	 * �����ѡ����
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement clear(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//i[@class='icon-clear-search']"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	
	/**
	 * ���ѡ�а�ť
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement clearbutton(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		element2 = driver.findElements(By.xpath("//span[contains(text(),'���ѡ��')]"));
		return element2.get(0);
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}
	/**
	 * ��ѡ������
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static WebElement SelectNumber(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		element=driver.findElement(By.xpath("//div[@class='sr-table']/div[1]/div[3]/div/span[@class='c-a-orange']"));
		return element;
	}
	
	
}

