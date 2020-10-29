package testLocatorss;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework2AddAndVerifyDeposit {


@Test
public void addAndVerifyDeposit() throws InterruptedException {
//Set Chrome as default browser
System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");

//Open Chrome Browserd
WebDriver driver = new ChromeDriver();

//Go to TechFios Website
driver.get("http://techfios.com/test/billing/?ng=admin/");
//Type username in the username field
driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");

//Type password in the password field
driver.findElement(By.name("password")).sendKeys("abc123");

//Click on Sign In button
driver.findElement(By.name("login")).click();
driver.findElement(By.linkText("Add Deposit")).click();
// driver.get("http://demo.guru99.com/test/newtours/register.php");
// WebElement element = driver.findElement(By.name("country"));
// Select select = new Select(element);
// select.selectByValue("ANGOLA");

Thread.sleep(3000);
WebElement element = driver.findElement(By.name("account"));
Select select = new Select(element);
select.selectByIndex(8);

driver.findElement(By.xpath("//select[@id='account']/option[@value='Sarker']")).click();
Random rnd = new Random();
int randomNumber = rnd.nextInt(999);
String description = "Shopping"+randomNumber;
String amount = String.valueOf(randomNumber);

//driver.findElement(By.name("description")).sendKeys(description);
driver.findElement(By.name("amount")).sendKeys(amount);
driver.findElement(By.id("submit")).click();
//Thread.sleep(5000);
By recentDepositLocator = By.linkText(description);
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(recentDepositLocator));
boolean status = driver.findElement(recentDepositLocator).isDisplayed();
if(status==true) {
System.out.println("Test Passed");
} else System.out.println("Test Failed!!");
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
