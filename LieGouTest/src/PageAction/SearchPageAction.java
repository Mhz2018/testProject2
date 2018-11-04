package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.SearchPageElement;

public class SearchPageAction {
	private static WebDriver driver;  
	//1�����췽���ķ�����������������ͬ��  
	//2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
	//3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ�������������� 
	public SearchPageAction(WebDriver driver){      
		this.driver = driver;   
		}       
	public static void Searchitem(WebDriver driver,int i,int j,String tenure) throws Exception 
	{       
		SearchPageElement.SearchList(driver).click();
		SearchPageElement.Keyword(driver).sendKeys("java C++");
		SearchPageElement.Anyey(driver).click();
		Thread.sleep(2000);
		SearchPageElement.IntentionalProfession(driver).click();
		Thread.sleep(2000);
		SearchPageElement.IntentionalProfession1(driver).click();
		Thread.sleep(2000);
		SearchPageElement.IntentionalProfession2(driver).get(i).click();
		Thread.sleep(2000);
		SearchPageElement.IntentionalProfession3(driver).click();
		//������
		//����
//		SearchPageElement.DesiredPlace(driver).click();
//		SearchPageElement.DesiredPlace1(driver, i).click();
//		SearchPageElement.DesiredPlace2(driver, j).click();
//		SearchPageElement.TenureEnterprise(driver).sendKeys(tenure);
		SearchPageElement.UpdateTime(driver).click();
		Thread.sleep(2000);
		SearchPageElement.UpdateTime1(driver).get(3).click();
			
	}
	public static void SearchExpansion(WebDriver driver,int i,int j,int k,int l,int m) throws Exception 
	{
		//չ��
		SearchPageElement.Openbutton(driver).click();
		Thread.sleep(2000);
		SearchPageElement.IndustryCustom(driver).click();
		SearchPageElement.IndustryCuston1(driver, i, j).click();
		
		SearchPageElement.IndustryCustonsure(driver).click();
		SearchPageElement.IndustryRecent(driver).click();
		
		SearchPageElement.experience(driver).get(k).click();
		//div[@class='show-industry-md-ri']
		SearchPageElement.Education(driver).get(l).click();
		SearchPageElement.SalaryExpectation(driver).get(m).click();
	}
	public static void SearchOther(WebDriver driver,int i,int j,int k,String school,String majar) throws Exception 
	{
		//չ��
		SearchPageElement.age(driver).click();
		SearchPageElement.age1(driver).get(i).click();
		SearchPageElement.sex(driver).click();
		SearchPageElement.sex1(driver).get(j).click();
		
		SearchPageElement.Jobtatus1(driver).click();
		SearchPageElement.Jobtatus2(driver).get(k).click();
		SearchPageElement.School(driver).sendKeys(school);
		SearchPageElement.major(driver).sendKeys(majar);
	}
	public static void SaveOther() throws Exception{
		
		SearchPageElement.Frequentlyusedsearch(driver).click();
		Thread.sleep(2000);
		int i=SearchPageElement.Savenum(driver).size();
		SearchPageElement.Saveto(driver).click();
		int j=SearchPageElement.Savenum(driver).size();
		assertEquals(j, i+1);
	}
}
