package PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResumePagElement {
	private static WebElement element;
	
	public static WebElement EnterpriseName(WebDriver driver){
		 //��ҵ����       
		 element = driver.findElement(By.cssSelector("input.el-input__inner"));       
		 return element;   
		 }
}
