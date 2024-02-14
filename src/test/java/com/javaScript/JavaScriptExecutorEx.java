package com.javaScript;


	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.remote.RemoteWebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	public class JavaScriptExecutorEx {

		static WebDriver driver;
		RemoteWebDriver re;
		
		public void waitForElement(WebElement element, long time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void moveAndClick(WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).click(element).build().perform();
		}
		
		public static void scrollingToView(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		@Test
		public void test01() throws Exception{
			WebElement uname, pass;
			RemoteWebDriver rd;
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
driver.get("file:///C:/Users/ATUL/Desktop/java%20class%20recording/selenium%20setup/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/logout.html");	
			//driver.navigate().to("");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;// type casting
			
			System.out.println(driver.getCurrentUrl());
			System.out.println("URL printed by JS "+js.executeScript("return document.URL;"));
			
			System.out.println(driver.getTitle());// jbk- log in
			System.out.println("title printed by JS " +js.executeScript("return document.title;"));
			
			// changing title by js
		     js.executeScript("document.title='updated title';");
		     System.out.println(driver.getTitle());// updated title
		     
		     driver.navigate().refresh();
		   //refreshing browser by js
		     js.executeScript("history.go(0);");
		     
		   //clicking element by js
		     js.executeScript("arguments[0].click();", uname=driver.findElement(By.id("email")));
		     
		     js.executeScript("document.getElementById('email').value='kiran@gmail.com';");

		     driver.findElement(By.id("email")).getAttribute("value");
		     
		     //clicking element by js

		     js.executeScript("arguments[0].click();", pass=driver.findElement(By.id("password")));

		     // using sendkeys by js

		     js.executeScript("document.getElementById('password').value='123456';");
		     
		  // creating alert by js
		     js.executeScript("alert('hello world');");//optional
		     Alert al = driver.switchTo().alert();
		     System.out.println(al.getText());
		     Thread.sleep(5000);
		     al.accept();
		     
		     //driver.navigate().to("");
		   //navigating to other url by js
		     js.executeScript("window.location='https://www.amazon.in/'");
		    
		     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     
		     WebElement footer_Logo=driver.findElement(By.xpath("//div[text()='See personalized recommendations']"));
		     js.executeScript("arguments[0].scrollIntoView(true);", footer_Logo);
		    // scrollingToView(footer_Logo);
		     
		     Thread.sleep(5000);
		     WebElement header_Logo=driver.findElement(By.xpath("//a[text()='Best Sellers']"));
		     
		     js.executeScript("arguments[0].scrollIntoView(true);", header_Logo);
		     
		    
		     
		}
		
		@Test
		public void testScroll() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement link=driver.findElement(By.xpath("//a[text()='Places']"));
		    js.executeScript("arguments[0].scrollIntoView(true);", link);
			
		}
		
		
		
		
	}


