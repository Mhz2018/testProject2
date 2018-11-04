package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageElement.LoginElement;
import PageElement.SearchPageElement;

public class SearchPageAction {
	private static WebDriver driver;  
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
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
		//工作地
		//不管
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
		//展开
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
		//展开
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
