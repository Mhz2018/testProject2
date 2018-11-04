package PageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageElement {
	private static WebElement element, element1;
	private static List<WebElement> element2;

	public static WebElement SearchList(WebDriver driver) throws Exception {
		// 搜索简历栏
		Thread.sleep(2000);
		element = driver.findElements(
				By.xpath("//li[@class='el-menu-item lh86']")).get(0);
		return element;
	}

	public static WebElement Keyword(WebDriver driver) throws Exception {
		// 关键字
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("input.el-input__inner"));
		return element;
	}

	public static WebElement Anyey(WebDriver driver)
			throws InterruptedException {
		// 任一关键字
		Thread.sleep(2000);
		element = driver.findElements(
				By.xpath("//span[@class='el-checkbox__label']")).get(0);
		return element;
	}

	public static WebElement SearchButton(WebDriver driver) throws Exception {
		// 搜索按钮
		Thread.sleep(2000);
		element = driver
				.findElements(
						By.xpath("//button[@class='el-button el-button--default']/span"))
				.get(0);
		return element;
	}

	public static WebElement CommonSearch(WebDriver driver) throws Exception {
		// 常用搜索
		Thread.sleep(2000);
		element = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span"));
		return element;
	}

	public static WebElement IntentionalProfession(WebDriver driver)
			throws Exception {
		// 意向职业
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("div.cont-div"));
		return element;
	}

	public static WebElement IntentionalProfession1(WebDriver driver)
			throws Exception {
		// 意向职业 -1级
		Thread.sleep(2000);
		element = driver.findElement(By
				.xpath("//ul[@class='show-industry-md']/li[3]/div"));
		return element;
	}

	public static List<WebElement> IntentionalProfession2(WebDriver driver)
			throws Exception {
		// 意向职业-2级
		Thread.sleep(2000);
		element2 = driver
				.findElements(By
						.xpath("//ul[@class='show-industry-md-le roll show']/li/ul/li"));
		return element2;
	}

	public static WebElement IntentionalProfession3(WebDriver driver)
			throws Exception {
		// 意向职业-确认
		Thread.sleep(2000);
		element = driver
				.findElement(By
						.xpath("//footer[@class='show-industry-bt']/button[@class='el-button el-button--primary el-button--mini']/span"));
		return element;
	}

	public static WebElement DesiredPlace(WebDriver driver) throws Exception {
		// 期望工作地
		Thread.sleep(2000);
		element = driver.findElement(By
				.xpath("//span[@class='el-cascader__label']"));
		return element;
	}

	public static WebElement DesiredPlace1(WebDriver driver, int i)
			throws Exception {
		// 期望工作地
		Thread.sleep(2000);
		element = driver.findElements(
				By.xpath("//ul[@class='el-cascader-menu']")).get(i);
		return element;
	}

	public static WebElement DesiredPlace2(WebDriver driver, int i)
			throws Exception {
		// 期望工作地
		Thread.sleep(2000);
		element = driver.findElements(
				By.xpath("//ul[@class='el-cascader-menu']")).get(i);
		return element;
	}

	public static WebElement TenureEnterprise(WebDriver driver)
			throws Exception {
		// 任职企业
		Thread.sleep(2000);
		element = driver.findElement(By
				.xpath("//input[@placeholder='请输入任职企业']"));
		return element;
	}

	public static WebElement NewestTenureEnterprise(WebDriver driver)
			throws Exception {
		// 最近任职企业
		Thread.sleep(2000);
		element = driver.findElement(By
				.xpath("//input[@placeholder='请输入任职企业']"));
		return element;
	}

	public static WebElement UpdateTime(WebDriver driver)
			throws InterruptedException {
		// 更新时间
		Thread.sleep(1000);
		element = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[1]/div[5]/div[2]/div/input"));
		return element;
	}

	public static List<WebElement> UpdateTime1(WebDriver driver)
			throws InterruptedException {
		// 更新时间 1
		Thread.sleep(1000);
		element2 = driver
				.findElements(By
						.xpath("//div[@x-placement='bottom-start']/div/div/ul[@class='el-scrollbar__view el-select-dropdown__list']/li"));

		return element2;
	}

	public static WebElement Openbutton(WebDriver driver) throws Exception {
		// 展开
		Thread.sleep(2000);
		element = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[1]/div[6]/button/span"));
		return element;
	}

	public static WebElement IndustryCustom(WebDriver driver) throws Exception {
		// 行业-自定义
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id='industry']/li[2]"));
		return element;
	}

	public static WebElement IndustryRecent(WebDriver driver) throws Exception {
		// 行业-最近
		Thread.sleep(2000);
		element = driver.findElement(By
				.xpath("//*[@id='industry']/li[3]/label/span[2]"));

		// *[@id="industry"]/li[2]
		// div[@class='show-industry-md-ri']
		// 计算机
		return element;
	}

	// 行业-选择
	public static WebElement IndustryCuston1(WebDriver driver, int i, int j)
			throws Exception {
		// 计算机
		Thread.sleep(3000);
		driver.findElements(By.xpath("//div[@class='show-industry-md-ri']"))
				.get(i).click();
		// 选择计算机软件
		element = driver.findElements(
				By.xpath("//ul[@class='show-industry-md-le roll show']/li"))
				.get(j);

		return element;
	}

	// 行业-选择
	public static WebElement IndustryCustonsure(WebDriver driver)
			throws Exception {
		Thread.sleep(2000);
		element = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div[2]/div/div[1]/div[2]/div[3]/div/div[2]/footer/button[2]/span"));
		return element;
	}

	public static WebElement IndustryNolimit(WebDriver driver) throws Exception {
		// 行业-不限
		Thread.sleep(2000);
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement ExperienceCcustom(WebDriver driver)
			throws Exception {
		// 经验-自定义
		Thread.sleep(2000);
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static List<WebElement> experience(WebDriver driver)
			throws Exception {
		// 经验
		Thread.sleep(2000);
		element2 = driver.findElements(By.xpath("//li[@name='workExp']"));
		return element2;
	}

	public static WebElement Educationustom(WebDriver driver) throws Exception {
		// 学历-自定义
		Thread.sleep(2000);
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static List<WebElement> Education(WebDriver driver) throws Exception {
		// 学历
		Thread.sleep(2000);
		element2 = driver.findElements(By.xpath("//li[@name='edu']"));
		return element2;
	}

	public static List<WebElement> SalaryExpectation(WebDriver driver)
			throws Exception {
		// 期望薪资
		Thread.sleep(2000);
		element2 = driver.findElements(By.xpath("//li[@name='salary']"));
		return element2;
	}

	public static WebElement age(WebDriver driver) throws Exception {
		// 年龄
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//input[@placeholder='年龄']"));
		return element;
	}

	public static List<WebElement> age1(WebDriver driver) throws Exception {
		// 年龄
		Thread.sleep(2000);
		element2 = driver
				.findElements(By
						.xpath("//div[@class='el-select-dropdown el-popper hide-drop-down-empty select-age']/div[1]/div[1]/ul/li"));
		return element2;
	}

	public static WebElement sex(WebDriver driver) throws Exception {
		// 性别按钮
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//input[@placeholder='性别']"));
		return element;
	}

	public static List<WebElement> sex1(WebDriver driver) throws Exception {
		// 性别
		Thread.sleep(2000);
		element2 = driver
				.findElements(By
						.xpath("//div[@class='el-select-dropdown el-popper'and @x-placement='bottom-start' ]"));
		return element2;
	}

	public static WebElement Place(WebDriver driver) throws Exception {
		// 居住地
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//input[@placeholder='现居地']"));
		return element;
	}

	public static List<WebElement> Place2(WebDriver driver) throws Exception {
		// 居住地
		Thread.sleep(2000);
		element2 = driver.findElements(By.xpath(""));
		return element2;

	}

	public static WebElement Registered(WebDriver driver) {
		// 户口
		element = driver.findElement(By.xpath("//*[@id='natP']/span"));
		return element;
	}

	public static WebElement Registered1(WebDriver driver) {
		// 户口-省
		element = driver.findElements(
				By.xpath("//*[@id='cascader-menu-9285']/li")).get(4);
		return element;
	}

	public static WebElement Registered2(WebDriver driver) {
		// 户口-市
		element = driver.findElement(By.xpath("//*[@id='menu-1152-1-4']"));
		return element;
	}

	public static WebElement Jobtatus1(WebDriver driver) {
		// 工作状态
		element = driver.findElement(By.xpath("//input[@placeholder='求职状态']"));
		return element;
	}

	public static List<WebElement> Jobtatus2(WebDriver driver) throws Exception {
		// 工作状态
		Thread.sleep(2000);
		element2 = driver
				.findElements(By
						.xpath("//div[@class='el-select-dropdown el-popper'and @x-placement='bottom-start' ]"));
		return element2;
	}

	public static WebElement School(WebDriver driver) {
		// 学校
		element = driver.findElement(By.xpath("//input[@placeholder='毕业院校']"));
		return element;
	}

	public static WebElement major(WebDriver driver) {
		// 专业
		element = driver.findElement(By.xpath("//input[@placeholder='所学专业']"));
		return element;
	}

	// 已选条件
	public static List<WebElement> SelectedConditions(WebDriver driver) {

		element2 = driver
				.findElements(By
						.xpath("//div[@id='app']/div/div[2]/div/div/div[2]/div[5]/div[2]/span"));
		return element2;
	}

	// 保存到搜索器
	public static WebElement Saveto(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//i[@class='icon-save-search']"));
		return element;
	}

	// 搜索器个数
	public static List<WebElement> Savenum(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		element2 = driver.findElements(By
				.xpath("//span[@class='pr20 max600 nowrap left']"));
		return element2;
	}

	// 常用搜索按钮
	public static WebElement Frequentlyusedsearch(WebDriver driver) throws Exception {
		Thread.sleep(6000);
		element = driver.findElement(By.xpath("xpath=(//button[@type='button'])[2]"));
		return element;
		//*[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span
	}

	// *[@id="app"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/button/span

	public static WebElement TemporaryResumes(WebDriver driver) {
		// 暂存简历
		element = driver
				.findElements(
						By.xpath("//button[@class='el-button el-button--default']/span"))
				.get(1);
		return element;
	}

	public static WebElement ViewDetails(WebDriver driver) {
		// 查看详情
		element = driver
				.findElements(
						By.xpath("//button[@class='el-button el-button--default']/span"))
				.get(2);
		return element;
	}

}
