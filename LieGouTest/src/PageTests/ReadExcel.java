package PageTests;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CommonObject.ExcelTestDto;
import PageAction.CommonAction;
import PageAction.LoginAction;
import PageAction.SearchItemAction;
import PageAction.SearchResultAction;
import PageElement.CommonElement;
import PageElement.SearchItemElement;
 
public class ReadExcel {
	public WebDriver driver;
	String url="http://192.168.0.150:81/";
	
	@DataProvider(name="TestData")
	public static Iterator<Object[]> readExcelWords() throws Exception 
	{
		return readExcelWordsData("d:\\","test123.xlsx","Sheet1");
	}
	
	@Test(dataProvider="TestData")
	public void testSearch(ExcelTestDto dto) throws Exception {
//			try{
				//int word1, int experience,int education, int  salaryExpectation,int age,int sex,int jobtatus
				SearchItemAction.searchItem(driver, 18, 16, dto.getWord1(), "");
				//SearchItemAction.SearchExpansion(driver, 0, 1, dto.getExperience(), dto.getEducation(),dto.getExperience());
				//SearchItemAction.SearchOther(driver,dto.getAge(), dto.getSex(), 18, 16, dto.getJobtatus(), "", "");
				//SearchItemAction.SelectedContent(driver);
				SearchItemElement.SearchButton(driver).click();
				//System.out.println("写入excel结果");
				Thread.sleep(3000);
				CommonAction.takescreen(driver);
				if (!isElementPresent()) {
					System.out.println("关键字："
							+ SearchResultAction.tableCell(driver,"free",1, 5));
					System.out.println("学历："
							+ SearchResultAction.tableCell(driver,"free", 1, 6));
					System.out.println("性别："
							+ SearchResultAction.tableCell(driver,"free", 1, 9));
					System.out.println("工龄："
							+ SearchResultAction.tableCell(driver,"free", 1, 7));
					System.out.println("工龄："
							+ SearchResultAction.tableCell(driver,"free", 1, 8));
					System.out.println("期望地："
							+ SearchResultAction.tableCell(driver,"free", 1, 10));
					System.out.println("更新时间："
							+ SearchResultAction.tableCell(driver,"free", 1, 11));
				}
//			}catch (Exception e){
//				System.out.println("写入excel结果--fail");
//			}
	}
	private boolean isElementPresent() {
			try {
				driver.findElement(By
						.xpath("//img[@src='/static/img/noResume.3f7cb11.jpg']"));
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}

		
	}

	@BeforeMethod
	public void BeforeMethod() throws Exception{
		driver =new FirefoxDriver();
		driver.get("http://192.168.0.150:81/");
		driver.manage().window().maximize();
		
		LoginAction la = new LoginAction(driver);
		// 输入用户名、密码
		la.Login("tangboanan@qq.com", "123456");
		Thread.sleep(2000);
		
		
	}
	@AfterMethod
	public void AfterMethod(){
		driver.quit();
	}
	
	//从Excel文件获取测试数据的静态方法
	public static Iterator<Object[]> readExcelWordsData(String filepath,String filename,String SheetName) throws IOException{
		Workbook Workbook = null;
		File file = new File(filepath + "\\" + filename);
	//	FileInputStream inputStream = new FileInputStream(file);
		
		InputStream in = new FileInputStream(file);//读取excel文件，建立一个输入流
		//获取文件扩展名
		String fileExtensionName = filename.substring(filename.indexOf("."));
		//判断是.xlsx还是.xls的文件并进行实例化
		if(fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(in);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(in);
		}
		//通过sheetName生成Sheet对象
		org.apache.poi.ss.usermodel.Sheet Sheet = Workbook.getSheet(SheetName);
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		System.out.println("rowCount: "+ rowCount);
		List<ExcelTestDto> records = new ArrayList<ExcelTestDto>();
		for(int i=1 ; i<rowCount+1; i++){
			Row row = Sheet.getRow(i);
			//int word1, int experience,int education, int  SalaryExpectation,int age,int sex,int Jobtatus
			ExcelTestDto dto = new ExcelTestDto();
			dto.setWord1((int)row.getCell(0).getNumericCellValue());
			dto.setExperience((int)row.getCell(1).getNumericCellValue());
			dto.setEducation((int)row.getCell(2).getNumericCellValue());
			dto.setSalaryExpectation((int)row.getCell(3).getNumericCellValue());
			dto.setAge((int)row.getCell(4).getNumericCellValue());
			dto.setSex((int)row.getCell(5).getNumericCellValue());
			dto.setJobtatus((int)row.getCell(6).getNumericCellValue());
			
			records.add(dto);
		}
		List<Object[]> results = new ArrayList<Object[]>();
        for (Object u : records) {
            //做一个形式转换
        	results.add(new Object[] { u });
        }
		/*Object[][] results = new Object[records.size()][];
		for (int i = 0 ; i < records.size();i++){
			results[i] = records.get(i);
		}*/
		return results.iterator();
	}
	
       
}
