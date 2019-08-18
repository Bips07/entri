package com.entriapp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest {
	WebDriver driver;
	String baseurl;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bipin/Documents/QA/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		baseurl="https://entri.app/";
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

  @Test (priority = 1)
  public void f() throws InterruptedException {	  
	  driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[1]/a")).click();
	  ArrayList<String> tabs=new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  WebDriverWait wait = new WebDriverWait(driver, 200);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"masthead\"]/nav/div[1]/div/div/a"))));
	  
	  
	  Actions act=new Actions(driver);
	  WebElement target = driver.findElement(By.xpath("//*[@id=\"menu-main-1\"]/li[2]/a"));
	  act.moveToElement(target).perform();
	  driver.findElement(By.xpath("//*[@id=\"menu-main-1\"]/li[2]/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	//  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/svg"))));
	
	  
	 driver.findElement(By.xpath("//*[@id=\"post-7962\"]/div/div[2]/header/h2/a")).click();
		  
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	  driver.findElement(By.xpath("//*[@id=\"menu-main-1\"]/li[8]/a")).click(); //Contact us
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"tc-navbar-outer-collapse\"]/ul/li[1]/a"))));
	  driver.findElement(By.xpath("//*[@id=\"tc-navbar-outer-collapse\"]/ul/li[1]/a")).click(); //for teachers button in contact us page
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a[1]"))));
	  driver.findElement(By.xpath(("//*[@id=\"myModal\"]/div/div/div[3]/a[1]"))).click(); //close button in pop up opened
	  //Entering details in Contact us form
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"id_name\"]")).sendKeys("Bipin E V");
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys("bipinev@outlook.com");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"id_phone\"]")).sendKeys("9645902329");
	  driver.findElement(By.xpath("//*[@id=\"id_description\"]")).sendKeys("Testing description");
	  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  Thread.sleep(1000);
	  driver.switchTo().window(tabs.get(0));
	  
	  
  }
  
  @Test (priority = 0)
  public void googleplay() throws InterruptedException
  {
	  if(driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div/a/img")).isDisplayed())
	  {
		  System.out.println("Correct Page loaded");
	  }
	  else
	  {
		  System.out.println("Incorrect Webpage loaded");
	  }
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  
	  driver.findElement(By.xpath("//*[@id=\"mastHead\"]/div[1]/div/div/a/figure/img")).click();// clicking on google play button
	 
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  ArrayList<String> tabs1=new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs1.get(1));
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"gbq1\"]/div/a/img"))));
	  String atitle=driver.getTitle();
	  if (driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[4]/c-wiz/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[1]/c-wiz[1]/h1/span")).isDisplayed())
	  {
		System.out.println("Correct Google play page loaded");  
	  }
	  else
	  {
		  System.out.println("Incorrect app loaded in play store");
	  }
	  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  driver.close();
	  driver.switchTo().window(tabs1.get(0));
  }

  
  @Test(priority = 2)
  public void teachers()
  {
	  driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[2]/a")).click(); //clicking on Teachers page
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	  //Entering teachers contact info
	  driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys("Bipin E V");
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("bipinev@outlook.com");
	  driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("9645902329");
	  driver.findElement(By.xpath("//*[@id=\"current_city\"]")).sendKeys("9645902329");
	  driver.findElement(By.xpath("//*[@id=\"experience\"]")).sendKeys("Testing description");
	  
	  driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div/a/span")).click();
  }
  
  @Test (priority = 3)
  public void team()
  {
	  driver.findElement(By.xpath("//*[@id=\"site-content\"]/footer/div/div[1]/div[3]/ul/li[2]/a")).click();
	  Actions act1=new Actions(driver);
	  WebElement target1=driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/img"));
	  act1.moveToElement(target1).perform();
	  driver.navigate().back();
	  
  }
  @AfterTest
  public void close()
  {
  driver.quit();
  }
}
