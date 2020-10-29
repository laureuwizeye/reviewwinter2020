package testLocatorss;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class VariousLocators {
	WebDriver driver;
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");	
	  driver = new ChromeDriver();
		
	 driver.get("https://www.objectspy.space/");
	driver.manage().window().maximize();
	
	}
		@Test
	public void test() throws InterruptedException {
		//8.x path for link
		driver.findElement(By.xpath("//Strong[contains(text(),'Link Test : New Page')]")).click();
		
		//1-3.using id or name or classname to find the location of an element
	driver.findElement(By.id("sex-0")).click();
		
	//7.using relative xpath to find the location of  an element	
	driver.findElement(By.xpath("//input[@id='sex-0']")).click();
	
	//4.find element by linktext,and 5.by partial linktext
	driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
	driver.findElement(By.partialLinkText("OS-API Product")).click();
	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	Thread.sleep(3000);
	//6.find element by cssSelector
	driver.findElement(By.cssSelector("input#exp-2")).click();
	Thread.sleep(3000);
	
	//driver.findElement(By.cssSelector("input.input-file")).click();
	//Thread.sleep(3000);
	
	//7.find element by relative X path
	//driver.findElement(By.xpath("//input[@class='input-file' and @name='photo']")).click();
	//Thread.sleep(3000);
	
	//or use tagname[attribute='value'] with this is: input[value='Manual Tester'] on the webpage/inspection example.
	//driver.findElement(By.cssSelector("input[value='Manual Tester']")).click();
	Thread.sleep(3000);
	
	
	
	}
	
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}
 
	
	
	
	
	
	
	
	
}
