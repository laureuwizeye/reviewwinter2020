package session4Revision;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandle {
	WebDriver driver;
	@Test
	public void handleiFrames() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.get("https://www.yahoo.com/");
	Thread.sleep(2000);
	//System.out.println(driver.getWindowHandles()); 
	driver.getTitle();
	
	driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
	Thread.sleep(2000);
	     
	driver.findElement(By.xpath("//input[@class='rapid-noclick-resp _yb_1syj2']")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
	 
	
	for (String i :driver.getWindowHandles() ) {
		driver.switchTo().window(i);
		
	}
	
driver.findElement(By.linkText("CSS")).click();
driver.findElement(By.linkText("SQL")).click();	
}
}