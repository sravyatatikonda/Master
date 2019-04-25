package sravya_1;

import java.io.File;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class launch_ie {
	public static ArrayList<String> h;
	public static ArrayList<String> k;
	public static WebDriver driver;
	private static XSSFWorkbook workbook;
	private static extentreport extent;
	public static  String errflpath;
	public static  String url;
@BeforeTest
	public static void main() throws InterruptedException, IOException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\TatikondaSravya\\Desktop\\New folder\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		extent = new extentreport();
		h = new ArrayList<String>();
		k = new ArrayList<String>();
		driver.get("https://www.thesouledstore.com/");
	}
@Test
	public static void clickOnMobileCovers() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div[2]/ul/li[1]/a"));
		e.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Mobile Covers')]")).click();
	}
@Test
	public static void clickOnOneplus() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'OnePlus 6T')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	public static String screenShot() throws IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		String time = dateFormat.format(date);
		File DestFile = new File("C:\\Users\\TatikondaSravya\\eclipse-workspace\\1207\\test-output\\"+time+".png");
		errflpath =  new String(DestFile.getAbsolutePath());
		FileUtils.copyFile(SrcFile, DestFile);
		k.add(errflpath);
		return errflpath;
		}
@Test
	public static void noofpages() throws IOException, InterruptedException {
		
		int noofpages = 0;
		try {
			for (int i = 2; i < 100; i++) {
				{
					if (i == 2) {

						driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/"
								+ "div/div/div[2]/div/div/div/div/ul/li[" + i + "]/span"));
					} else {
						WebElement S = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/"
								+ "div/div/div[2]/div/div/div/div/ul/li[" + i + "]/span"));
						S.click();
						noofpages++;
					}
	
				}
				urlExtrcter();
			}
	
			
		} catch (Exception e) {
		}
		clickOnUrl();
		System.out.println("The number of pages are " + noofpages);
	}
@Test
	public static void urlExtrcter() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		List<WebElement> covers = driver.findElements(By.tagName("a"));
		{
		for (int i = 0; i < covers.size(); i++) {
			 url = new String ("");
			url = covers.get(i).getAttribute("href");
			
			if (url.contains("product/harry")) {
		
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				h.add(url);	
					
			}
		}
		}
		
}

	public static void clickOnUrl() throws InterruptedException, IOException {
		  try {
			  {
		for(int j = 0; j < h.size(); j++){
			
		String k=h.get(j);
		driver.navigate().to(k);
		screenShot();
		driver.navigate().back();
		}
		  }
		  }
		  catch (ArrayIndexOutOfBoundsException e) {
		         System.out.println("Array is out of Bounds"+e);
		  }
		  Excelwriter();
	}
	public static void Excelwriter() throws IOException {
		try {
			extent.report();
			System.out.println(h.size());
			workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
			XSSFRow row;
			XSSFRow rowheader = spreadsheet.createRow(0);
			Cell cell1 = rowheader.createCell(0);
			Cell cell2 = rowheader.createCell(1);
			cell1.setCellValue("Serial no");
			cell2.setCellValue("Urls for HP");
			for (int j = 1; j < (h.size() + 1); j++) {
				row = spreadsheet.createRow(j);
				Cell cellserialno = row.createCell(0);
				cellserialno.setCellValue(((j - 1)));
				Cell cell = row.createCell(1);
				cell.setCellValue((h.get((j - 1))));
			}
			FileOutputStream out = new FileOutputStream(new File("C:/Users/TatikondaSravya/Desktop/hp4.xlsx"));

			workbook.write(out);
			out.close();
			System.out.println("Writesheet.xlsx written successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*@AfterMethod
	public void afterMethod() throws IOException, InterruptedException {
		screenShot();
		extent.report();
	}*/

}

