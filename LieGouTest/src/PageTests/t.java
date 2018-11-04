package PageTests;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List; 
import java.util.concurrent.TimeUnit; /**
 * Created by deng on 2018/3/6.
 */ public class t {
	 private final static String TARGET_URL = "http://sports.sina.com.cn/nba/"; 
	 private final static String FILE_NAME = "/Users/deng/IdeaProjects/Spider/src/SinaSportsNews.txt";
	 public void run() throws InterruptedException {
		 StringBuilder allNewses = new StringBuilder();
		 WebDriver driver = new FirefoxDriver();
		 driver.get(TARGET_URL);
		 WebDriver newsDriver = new FirefoxDriver(); 
		 // ����8�뼴Ϊ��ʱ�����׳�Exception newsDriver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS); 
		 Document document = Jsoup.parse(driver.getPageSource()); 
		 List<Element> liTags = document.getElementsByClass("item");
		 for (int i = 0; i < 3; i++) {
			 List<Element> aTags = liTags.get(i).getElementsByTag("a");
			 // ������������ 
			 for (Element a : aTags) { String href = a.attr("href"); 
			 // ɸѡ�����ŵ�url
			 if (href.contains("sports.sina.com.cn") && href.contains("shtml")) {
				 System.out.println(href); 
				 allNewses.append(href + "\n"); 
				 try { newsDriver.get(href); } 
				 catch (Exception e) {
					 // ����ҳ�泬ʱ��ִ��js�ֶ�ֹͣҳ�����
					 ((JavascriptExecutor) newsDriver).executeScript("window.stop()");
					 }
				 finally {
						 Document newsDocument = Jsoup.parse(newsDriver.getPageSource());
						 String title = newsDocument.getElementsByClass("main-title").get(0).text(); 
						 Element dateAndSource = newsDocument.getElementsByClass("date-source").get(0);
						 String date = dateAndSource.getElementsByTag("span").get(0).text(); 
						 String source = dateAndSource.getElementsByTag("a").get(0).text(); 
						 allNewses.append(title + "\n"); allNewses.append(date + " " + source + "\n");
						 Element article = newsDocument.getElementById("artibody"); 
						 for (Element p : article.getElementsByTag("p")) {
							 allNewses.append(p.text().trim() + "\n"); } } } } } 
		 Thread.sleep(3000); driver.quit(); newsDriver.quit();
	//	 MyFileWriter.writeString(FILE_NAME, allNewses.toString());
		 System.out.println(allNewses.toString());
		 } 
	 public static void main(String[] args) {
		 try {
			 new t().run();
			 } 
		 catch (InterruptedException e) {
			 e.printStackTrace();
			 } }


 }
