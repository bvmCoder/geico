package com.geico.qa.DataDrivenTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.geico.test.utility.testUtility;

public class GeicoTest {
	
	WebDriver driver;
	
	@BeforeMethod
	  public void setUp(){
		System.setProperty("webdriver.chrome.driver","/Users/bp/Documents/workspace/Geico/chromedriver 4");
	    driver = new ChromeDriver();//launch chrome driver
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    
	    driver.get("https://auto-buy.geico.com/nb#/sale/customerinformation/gskmsi");
		}
	@DataProvider
	   public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = testUtility.getDataFromExcel();
		return testData.iterator();
	   }
		
	
	@Test(dataProvider="getTestData",priority=1)
	   public void geicoRegTest(String firstName,String lastName,String Address,String Apt,String Zipcode,String MonthDOB,String DayDOB,String YearDOB){
		
		 driver.findElement(By.xpath("//*[@id='firstName']")).clear(); 
         driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
        
         driver.findElement(By.xpath("//*[@id='lastName']")).clear(); 
   	     driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
   	    
   	     driver.findElement(By.xpath("//*[@id='street']")).clear(); 
   	     driver.findElement(By.xpath("//*[@id='street']")).sendKeys(Address);
   	    
   	     driver.findElement(By.xpath("//*[@id='apt']")).clear(); 
   	     driver.findElement(By.xpath("//*[@id='apt']")).sendKeys(Apt);
   	    
   	     driver.findElement(By.xpath("//*[@id='zip']")).clear(); 
   	     driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(Zipcode);
   	    
   	     
   	     driver.findElement(By.xpath("//*[@id='date-monthdob']")).clear(); 
	     driver.findElement(By.xpath("//*[@id='date-monthdob']")).sendKeys(MonthDOB);
	     
	     driver.findElement(By.xpath("//*[@id='date-daydob']")).clear(); 
   	     driver.findElement(By.xpath("//*[@id='date-daydob']")).sendKeys(DayDOB);
   	     
   	     driver.findElement(By.xpath("//*[@id='date-yeardob']")).clear(); 
	     driver.findElement(By.xpath("//*[@id='date-yeardob']")).sendKeys(YearDOB);
	     
	     driver.findElement(By.id("btnSubmit")).click();
		
	}
	
	@AfterMethod
	public void tearDown(){
	    //driver.quit();
	
		
	}
}
