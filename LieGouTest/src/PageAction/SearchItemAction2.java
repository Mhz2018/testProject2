package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import PageElement.SearchItemElement;

public class SearchItemAction2 {
	private static WebDriver driver;
	private static String s="";
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	public SearchItemAction2(WebDriver driver){      
		this.driver = driver;   
		}      
	/**
	 * �������
	 * ��������������ť���ؼ��֣���һ�ؼ��֣�����ְҵ������������
	 * ��ְ��ҵ������ʱ��
	 * @param driver
	 * @param ip1
	 * @param ip2
	 * @param udt2
	 * @param tenure
	 * @throws Exception
	 */
	public static void Searchitem(WebDriver driver,int ip1,int ip2,int udt2,String tenure) throws Exception 
	{       
		SearchItemElement.SearchList(driver).click();
		SearchItemElement.Keyword(driver).sendKeys("���� ����");
		SearchItemElement.Anyey(driver).click();
		Thread.sleep(2000);
	
//		SearchItemElement.IntentionalProfessionsure(driver).click();
//		Thread.sleep(2000);
		SearchItemElement.DesiredPlace(driver).click();
		CommonAction.clickProvinceAndcity(driver, ip1, ip2);
		Thread.sleep(2000);
		SearchItemElement.TenureEnterprise(driver).sendKeys(tenure);
		Thread.sleep(2000);
		SearchItemElement.UpdateTime(driver).click();
		Thread.sleep(2000);
		SearchItemElement.UpdateTime1(driver,udt2).click();
			
	}
	/**
	 * ����ְҵ
	 * @param driver
	 * @throws Exception
	 */
	public static void sear(WebDriver driver) throws Exception
	{
		SearchItemElement.SearchList(driver).click();
		SearchItemElement.IntentionalProfession(driver).click();
		Thread.sleep(2000);
		SearchItemElement.IntentionalProfession1(driver).click();
		Thread.sleep(2000);
		SearchItemElement.IntentionalProfession2(driver).click();
		Thread.sleep(2000);
		SearchItemElement.IntentionalProfessionsure(driver).click();
	}
	/**
	 *  չ��
	 *  ��ҵ
	 *  ��������
	 *  ����
	 *  ����н��
	 * @param driver
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @param m
	 * @throws Exception
	 */ 
	public static void SearchExpansion(WebDriver driver,int industrycuston1,int industrycuston2,int experience,int education,int salaryexpectation,int he) throws Exception 
	{
		SearchItemElement.Openbutton(driver).click();
		SearchItemElement.IndustryCustom(driver).click();
		SearchItemElement.IndustryCuston1(driver,industrycuston1, industrycuston2).click();
		
		SearchItemElement.IndustryCustonsure(driver).click();
		SearchItemElement.IndustryRecent(driver).click();
		
		SearchItemElement.experience(driver).get(experience).click();
		SearchItemElement.Education(driver).get(education).click();
		SearchItemElement.SalaryExpectation(driver).get(salaryexpectation).click();
		Thread.sleep(2000);
		Highlyeducated(driver, he);
		
	}
	/**
	 * ��ѧ��
	 * @param driver
	 * @param i
	 */
	public static void Highlyeducated(WebDriver driver,int i)
	{
		SearchItemElement.Highlyeducated(driver).get(i).click();
		SearchItemElement.overseas(driver).click();
	}
	/**
	 * ����
	 * �Ա�
	 * ���е�
	 * ����״̬
	 * ����
	 * ԺУ
	 * רҵ
	 * @param driver
	 * @param i
	 * @param j
	 * @param k
	 * @param school
	 * @param majar
	 * @throws Exception
	 */
	public static void SearchOther(WebDriver driver,int age1,int sex,int province,int city,int job,String school,String majar) throws Exception 
	{
		//չ��
		SearchItemElement.age(driver).click();
		SearchItemElement.age1(driver).get(age1).click();
		
		SearchItemElement.sex(driver).click();	
		SearchItemElement.sex1(driver).get(sex).click();
		SearchItemElement.Place(driver).click();
		CommonAction.clickProvinceAndcity(driver, province, city);
		
		SearchItemElement.Jobtatus1(driver).click();
		Thread.sleep(2000);
		SearchItemElement.Jobtatus2(driver).get(job).click();
		Thread.sleep(2000);
		SearchItemElement.Registered(driver).click();
		CommonAction.clickProvinceAndcity(driver, province, city);
		
		SearchItemElement.School(driver).sendKeys(school);
		SearchItemElement.major(driver).sendKeys(majar);
		SearchItemElement.Takeup(driver).click();
	}
	/**
	 * ���浽������
	 * @throws Exception 
	 */
	public static void Savetolist(WebDriver driver) throws Exception
	{
		
		SearchItemElement.Frequentlyusedsearch(driver).click();
		int i=SearchItemElement.Savenum(driver).size();
		System.out.println(i);
		SearchItemElement.Saveto(driver).click();
		Thread.sleep(1000);
       
    	assertEquals(SearchItemElement.message(driver).getText(), "�����������ɹ�, �������������...");	
		SearchItemElement.Frequentlyusedsearch(driver).click();
		Thread.sleep(2000);
		assertEquals(SearchItemElement.Savenum(driver).size(), i+1);
		
		
		
	}
	/**
	 * ������ť
	 */
	public static void search(WebDriver driver) throws Exception
	{
		SearchItemElement.SearchButton(driver).click();
	}
	/**
	 * ��ѡ��������
	 */
	 public static void  SelectedContent(WebDriver driver) throws Exception
	{
		int j= SearchItemElement.SelectedConditions(driver).size();
		System.out.println(j);
		 for (int i=0;i<j;i++)
		 {
			 s= SearchItemElement.SelectedConditions(driver).get(i).getText();
			System.out.println("��ѡ����:"+s);
		//	assertEquals(SearchResultAction.tableCell(driver,1,5),s);
		 }
		 
		 
	} 
	 
	
	
	
}
