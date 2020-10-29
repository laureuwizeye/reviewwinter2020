package session4Revision;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	@Test
public void DropDownExample () throws InterruptedException {	
	
	WebDriver driver;
	
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\geckodriver.exe");
	
	//create an object=
	 driver = new FirefoxDriver();	
	 driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
	 driver.get("http://techfios.com/test/billing/?ng=admin/"); 
	 
	 WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
	 
	//identifying the username box and passing username
	 USERNAME_ELEMENT.clear();
	 USERNAME_ELEMENT.sendKeys("techfiosdemo@gmail.com");
	 
	//identifying the password box and passing password 
	 driver.findElement(By.name("password")).sendKeys("abc123");
	 driver.findElement(By.name("login")).click();
	 
driver.findElement(By.xpath("//span[contains(text(),'CRM')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[contains(text(),'Add Contact')]")).click();
Thread.sleep(2000);
WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("//div[@class='form-group']//descendant::select[@id='country']"));
//WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("div[@class='form-group']//select[@id='country']"));
Select sel = new Select(DROPDOWN_LOCATOR);
sel.selectByVisibleText("Algeria");

	 
}
}