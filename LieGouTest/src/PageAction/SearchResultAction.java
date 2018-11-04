package PageAction;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import CommonObject.SearchConditionDto;
import PageElement.CommonElement;
import PageElement.SearchItemElement;
import PageElement.SearchResultElement;
import PageElement.TempPageElement;

public class SearchResultAction {

	/**
	 * 获取行列数据
	 * 
	 * @throws Exception
	 */
	public static String tableCell(WebDriver driver, String webName, int row, int column) throws Exception {
		Thread.sleep(2000);
		String text = null;
		// avoid get the head line of the table
		row = row + 1;
		// System.out.println(row);
		// 列表-根据行列
		// String
		// xpath="//div[@class='el-table__body-wrapper
		// is-scrolling-none']/table[@class='el-table__body']/tbody/tr["+row+"]/td["+column+"]/div/div";
		// "//*[@id='table138']/tbody/tr["+row+"]/td["+column+"]";

		// WebElement table=driver.findElement(;
		// //*[@id="table138"]/tbody/tr[1]/td[1]/strong

		text = SearchResultElement.TableContent(driver, webName, row, column).getText();
		// System.out.println(text);
		return text;

	}

	/**
	 * 勾选框
	 * 
	 * @param driver
	 * @param row
	 * @throws Exception
	 */
	public static void CheckOut(WebDriver driver, String webName, int row,int count) throws Exception {
		SearchResultElement.TableContent(driver, webName, row, count).click();

	}

	/**
	 * test某行某列的数据
	 */
	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://192.168.0.150:81/");
		driver.manage().window().maximize();
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请输入关键字搜索简历']")).sendKeys("java");
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[1]/div/button/span")).click();
		Thread.sleep(2000);

		System.out.println(tableCell(driver, "free", 1, 13));
		Thread.sleep(2000);
		SearchResultElement.joinpk(driver, 2).click();
		SearchResultElement.joinpk(driver, 3).click();
		// SearchResultElement.pkButton(driver);
		Thread.sleep(2000);
		String i = SearchResultElement.pknum(driver).getText();
		System.out.println(i);
		SearchResultElement.pkButton(driver).click();
		;
		SearchResultElement.deletebutton(driver).click();

	}

	/**
	 * 勾选简历，确认勾选是否正常
	 * 
	 * @throws Exception
	 */
	public static void CheckOutTrue(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		SearchResultAction.CheckOut(driver, "free", 2, 1);
		SearchResultAction.CheckOut(driver, "free", 3, 1);
		Thread.sleep(2000);
		// System.out.println(SearchItemElement.SelectNumber(driver).getText());
		assertEquals(SearchItemElement.SelectNumber(driver).getText(), "2");
		SearchItemElement.clearbutton(driver).click();
		assertEquals(SearchItemElement.SelectNumber(driver).getText(), "0");
	}

	/**
	 * 暂存按钮是否正常
	 * 
	 * @throws Exception
	 */
	public static void temporaryStorage(WebDriver driver) throws Exception {

		SearchResultAction.CheckOut(driver, "free", 2, 1);
		TempResumeAction.tempRe(driver);
	    CommonElement.getSearchPage(driver).click();
		SearchItemElement.TemporaryResumes(driver).click();
		assertEquals(SearchItemElement.message(driver).getText(), "您所选的简历暂存成功！");
		TempResumeAction.tempRe(driver);
		TempResumeAction.getCancelStore(driver);
	}

	/**
	 * 搜索条件和结果对比方法
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void compareConditionAndReault(WebDriver driver) throws Exception {
		if (!isElementPresent(driver)) {
			SearchConditionDto conditionDto = getSearchConditionDto(driver);
			List<SearchConditionDto> tableList = getSearchResultTableList(driver);
			if (compareConditionAndTableList(conditionDto, tableList)) {
				System.out.println("搜索结果正确");
			} else {
				System.out.println("搜索结果异常");
			}

		}
	}

	private static List<SearchConditionDto> getSearchResultTableList(WebDriver driver) {

		List<SearchConditionDto> resultDtolist = new ArrayList<SearchConditionDto>();

		List<WebElement> lins = driver.findElements(By.xpath(
				"//div[@id='app']/div/div[@class='content']/div/div[@class='sr-table']/div[1]/div[1]/div[3]/table/tbody/tr[@class='el-table__row']"));
		for (int i = 0; i < lins.size(); i++) {
			List<WebElement> cells = lins.get(i).findElements(By.xpath(".//div[@class='cell']"));
			SearchConditionDto resultDto = new SearchConditionDto();

			resultDto.setDesiredPlace(cells.get(9).getText());
			resultDto.setAge(cells.get(7).getText());
			resultDto.setEducationustom(cells.get(5).getText());
			resultDto.setExperience(cells.get(6).getText());
			resultDto.setIntentionalProfession(cells.get(4).getText());
			resultDto.setName(cells.get(2).getText());
			resultDto.setSex(cells.get(8).getText());
			resultDto.setUpdateTime(cells.get(10).getText());
			resultDtolist.add(resultDto);
		}
		/*
		 * for (int i = 0; i < resultDtolist.size(); i++) {
		 * System.out.println(resultDtolist.get(i).getName() + "----姓名------  ");
		 * System.out.println(resultDtolist.get(i).getAge() + "----年龄------  ");
		 * System.out.println(resultDtolist.get(i).getDesiredPlace()+
		 * "----工作点------  ");
		 * System.out.println(resultDtolist.get(i).getEducationustom() +
		 * "----学历------  "); System.out.println(resultDtolist.get(i).getExperience() +
		 * "----年限------  ");
		 * System.out.println(resultDtolist.get(i).getIntentionalProfession()+
		 * "----职业------  "); System.out.println(resultDtolist.get(i).getSex()+
		 * "----性别------  "); }
		 */
		return resultDtolist;
	}

	private static SearchConditionDto getSearchConditionDto(WebDriver driver) throws Exception {
		SearchConditionDto conditionDto = new SearchConditionDto();

		String intentionalProfession = SearchItemElement.IntentionalProfession(driver).getText();
		String desiredPlace = SearchItemElement.DesiredPlace(driver).getText();
		String updateTime = SearchItemElement.UpdateTime(driver).getText();
		String age = SearchItemElement.age(driver).getText();
		String sex = SearchItemElement.sex(driver).getText();
		String experience = SearchItemElement.getChooseworkExp(driver).getText();
		String educationustom = SearchItemElement.getChooseedu(driver).getText();
		conditionDto.setIntentionalProfession(intentionalProfession);
		conditionDto.setAge(age);
		conditionDto.setDesiredPlace(desiredPlace);
		conditionDto.setEducationustom(educationustom);
		conditionDto.setExperience(experience);
		conditionDto.setSex(sex);
		conditionDto.setUpdateTime(updateTime);

		return conditionDto;
	}

	private static boolean isElementPresent(WebDriver driver) {

		try {
//			driver.findElement(By.xpath("//span[@class='el-table__empty-text']"));
			driver.findElement(By.xpath("//img[@src='/static/img/noResume.3f7cb11.jpg']"));
			System.out.println("---没有数据或者等待時間太短，数据未加载 ");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	private static boolean compareConditionAndTableList(SearchConditionDto conditionDto,
			List<SearchConditionDto> tableList) {
		for (SearchConditionDto tableDto : tableList) {
//			if (!compareIntentionalProfession(conditionDto.getIntentionalProfession(),
//					tableDto.getIntentionalProfession())) {
//				System.out.println("compareIntentionalProfession:"+tableDto.getIntentionalProfession());
//				return false;
//			}
			if (!compareDesiredPlace(conditionDto.getDesiredPlace(), tableDto.getDesiredPlace())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getDesiredPlace());
				return false;
			}
			if (!compareUpdateTime(conditionDto.getUpdateTime(), tableDto.getUpdateTime())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getUpdateTime());
				return false;
			}
			if (!compareEducationustom(conditionDto.getEducationustom(), tableDto.getEducationustom())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getEducationustom());
				return false;
			}
			if (!compareAge(conditionDto.getAge(), tableDto.getAge())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getAge());
				return false;
			}
			if (!compareSex(conditionDto.getSex(), tableDto.getSex())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getSex());
				return false;
			}
			if (!compareExperience(conditionDto.getExperience(), tableDto.getExperience())) {
				System.out.println("compareIntentionalProfession:"+tableDto.getExperience());
				return false;
			}
		}
		return true;
	}
/**
 * 比较工作年限
 * @param condition
 * @param result
 * @return
 */
	private static boolean compareExperience(String condition, String result) {
		if (condition == null || condition.equals("") || condition.equals("不限")) {
			return true;
		}
		result.replace("年", "");
		int resultexp = Integer.parseInt(result);
		switch (condition) {
		case "1~3年":
			if (resultexp >= 1 && resultexp <= 3)
				return true;
			break;
		case "3~5年":
			if (resultexp >= 3 && resultexp <= 5)
				return true;
			break;
		case "5~10年":
			if (resultexp >= 3 && resultexp <= 5)
				return true;
			break;
		case "10年以上":
			if (resultexp >= 10)
				return true;
			break;

		default:
			break;
		}
		return false;
	}
	/**
	 * 比较性别
	 */
	private static boolean compareSex(String condition, String result) {
		if (condition == null || condition.equals("") || condition.equals("不限")) {
			return true;
		}
		return condition.equals(result);
	}

	/**
	 * 比较年龄
	 */
	private static boolean compareAge(String condition, String result) {
		if (condition == null || condition.equals("")) {
			return true;
		}
		boolean t = false;
		int resultAge = Integer.parseInt(result);
		switch (condition) {
		case "不限":
			t = true;
			break;
		case "19岁以下":
			if (resultAge <= 19) {
				t = true;
			}
			break;
		case "20~25岁":
			if (resultAge >= 20 && resultAge <= 25) {
				t = true;
			}
			break;
		case "26~30岁":
			if (resultAge >= 26 && resultAge <= 30) {
				t = true;
			}
			break;
		case "31~45岁":
			if (resultAge >= 31 && resultAge <= 45) {
				t = true;
			}
			break;
		case "46以上":
			if (resultAge >= 46) {
				t = true;
			}
			break;
		case "16~60岁":
			if (resultAge >= 16 && resultAge <= 60) {
				t = true;
			}
			break;
		default:
			break;
		}
		return t;
	}

	/**
	 * 比较 学历
	 */
	private static boolean compareEducationustom(String condition, String result) {

		if (condition == null || condition.equals("")) {
			return true;
		}
		switch (condition) {
		case "不限":
			return true;
		case "大专以上":
			condition = "本科,硕士,博士";
			break;
		case "本科以上":
			condition = "硕士,博士";
			break;
		default:
			break;
		}
		return compare("educationustom", condition, result, "equals");
		/*
		 * switch (condition) { case "大专": return condition.equals(result); case "本科":
		 * return condition.equals(result); case "硕士": return condition.equals(result);
		 * case "博士": return condition.equals(result); case "大专以上":
		 * condition="本科，硕士，博士"; return compare("educationustom",condition, result);
		 * case "本科以上": condition="硕士，博士"; return compare("educationustom",condition,
		 * result); default: break; } return false;
		 */
	}

	/**
	 * 比较 更新时间
	 */
	private static boolean compareUpdateTime(String condition, String result) {

		if (condition == null || condition.equals("")) {
			return true;
		}
		Date resultDate = null;
		Date startDate = new Date();
		Date endDate = new Date();
		String dateFormat = "yyyy-MM-dd";
		try {
			DateFormat df = new SimpleDateFormat(dateFormat);
			resultDate = df.parse(result);

			switch (condition) {
			case "最近3天":
				startDate = CommonAction.getDateByBefore("day", 3);
				break;
			case "最近1周":
				startDate = CommonAction.getDateByBefore("week", 1);
				break;
			case "最近2周":
				startDate = CommonAction.getDateByBefore("week", 2);
				break;
			case "最近1月":
				startDate = CommonAction.getDateByBefore("month", 1);
				break;
			case "最近2月":
				startDate = CommonAction.getDateByBefore("month", 2);
				break;
			case "最近3月":
				startDate = CommonAction.getDateByBefore("month", 3);
				break;
			case "最近6月":
				startDate = CommonAction.getDateByBefore("month", 6);
				break;
			case "最近1年":
				startDate = CommonAction.getDateByBefore("year", 1);
				break;
			case "1年以上":
				startDate = df.parse("1949-10-1");
				endDate = CommonAction.getDateByBefore("year", 1);
				break;
			default:
				break;
			}
		} catch (ParseException e) {
			return false;
		}
		return CommonAction.isEffectiveDate(resultDate, startDate, endDate);
	}

	/**
	 * 比较期望工作地
	 */
	private static boolean compareDesiredPlace(String condition, String result) {
		if (condition == null || condition.equals("")) {
			return true;
		}
		return compare("desiredPlace", condition, result, "indexOf");
	}

	/**
	 * 比较 意向职业
	 */
	private static boolean compareIntentionalProfession(String condition, String result) {
		if (condition == null || condition.equals("")) {
			return true;
		}
		return compare("intentionalProfession", condition, result, "indexOf");
	}

	private static boolean compare(String type, String condition, String result, String method) {
		String[] conditions = condition.split(",");
		String[] results = result.split(",");
		for (int i = 0; i < conditions.length; i++) {
			String con = conditions[i];
			if (type.equals("desiredPlace")) {
				if (con.endsWith("市县")) {
					con = con.substring(0, con.length() - 2);
				} else if (con.endsWith("县") || con.endsWith("市")) {
					con = con.substring(0, con.length() - 1);
				}
			}
			// i=0,j所有的对比
			for (int j = 0; j < results.length; j++) {
				if (method.equals("equals")) {
					if (results[j].equals(con)) {
						return true;
					}
				} else {
					if (results[j].indexOf(con) > -1) {
						return true;
					}
				}
			}
		}
		System.out.println("对比错误：" + condition + "  ---  " + result);
		return false;
	}

}
