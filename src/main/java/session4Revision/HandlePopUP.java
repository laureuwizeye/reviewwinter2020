package session4Revision;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUP {
	
	@Test
	public void handlePopUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	// Go to Rediff Site
	// Click on the go button
	// Close the popup
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
	driver.findElement(By.xpath("//input[@name='FormName']/following-sibling::div/descendant::input[@value='Go']")).click();
	Thread.sleep(3000);
	//driver.switchTo().alert().accept();	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
