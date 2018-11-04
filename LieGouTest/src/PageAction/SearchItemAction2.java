package PageAction;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import PageElement.SearchItemElement;

public class SearchItemAction2 {
	private static WebDriver driver;
	private static String s="";
	//1）构造方法的方法名必须与类名相同。  
	//2）构造方法没有返回类型，也不能定义为void，在方法名前面不声明方法类型。
	//3）构造方法的主要作用是完成对象的初始化工作，它能够把定义对象时的参数传给对象的域。 
	public SearchItemAction2(WebDriver driver){      
		this.driver = driver;   
		}      
	/**
	 * 搜索主项：
	 * 导航栏的搜索按钮，关键字，任一关键字，意向职业，期望工作地
	 * 任职企业，更新时间
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
		SearchItemElement.Keyword(driver).sendKeys("销售 测试");
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
	 * 意向职业
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
	 *  展开
	 *  行业
	 *  工作经验
	 *  教育
	 *  期望薪资
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
	 * 高学历
	 * @param driver
	 * @param i
	 */
	public static void Highlyeducated(WebDriver driver,int i)
	{
		SearchItemElement.Highlyeducated(driver).get(i).click();
		SearchItemElement.overseas(driver).click();
	}
	/**
	 * 年龄
	 * 性别
	 * 居中地
	 * 工作状态
	 * 户口
	 * 院校
	 * 专业
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
		//展开
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
	 * 保存到搜索器
	 * @throws Exception 
	 */
	public static void Savetolist(WebDriver driver) throws Exception
	{
		
		SearchItemElement.Frequentlyusedsearch(driver).click();
		int i=SearchItemElement.Savenum(driver).size();
		System.out.println(i);
		SearchItemElement.Saveto(driver).click();
		Thread.sleep(1000);
       
    	assertEquals(SearchItemElement.message(driver).getText(), "存入搜索器成功, 点击搜索器试试...");	
		SearchItemElement.Frequentlyusedsearch(driver).click();
		Thread.sleep(2000);
		assertEquals(SearchItemElement.Savenum(driver).size(), i+1);
		
		
		
	}
	/**
	 * 搜索按钮
	 */
	public static void search(WebDriver driver) throws Exception
	{
		SearchItemElement.SearchButton(driver).click();
	}
	/**
	 * 已选条件内容
	 */
	 public static void  SelectedContent(WebDriver driver) throws Exception
	{
		int j= SearchItemElement.SelectedConditions(driver).size();
		System.out.println(j);
		 for (int i=0;i<j;i++)
		 {
			 s= SearchItemElement.SelectedConditions(driver).get(i).getText();
			System.out.println("已选条件:"+s);
		//	assertEquals(SearchResultAction.tableCell(driver,1,5),s);
		 }
		 
		 
	} 
	 
	
	
	
}
