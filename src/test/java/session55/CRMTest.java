package session55;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMTest {

WebDriver driver;

@BeforeTest
public void inIt() {	
String browser = "Firefox";

if (browser.equalsIgnoreCase("Chrome")) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();

} else if (browser.equalsIgnoreCase("Firefox")) {
	System.setProperty("webdriver.gecko.driver",
			"C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\geckodriver.exe");
	driver = new FirefoxDriver();

}

// driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

driver.get("http://techfios.com/test/billing/?ng=admin/");
	
}

@Test(priority=1)
	public void loginTest() throws InterruptedException {
		// Element Library
		By USER_NAME_FIELD = By.xpath("(//input[@class='form-control'])[1]");
		By PASSWORD_FIELD = By.xpath("//input[contains(@type, 'pass')]");
		By SIGNIN_BUTTON = By.xpath("//*[contains(@class, 'success block') and @type='submit']");
		
		//replace web element values by BY
		//1.WebElement usernameField = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		//2.WebElement passwordField = driver.findElement(By.xpath("//input[contains(@type, 'pass')]"));
		//3.WebElement signInButton = driver.findElement(By.xpath("//*[contains(@class, 'success block') and @type='submit']"));

		//DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";
		
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
		Thread.sleep(2000);
	}

@AfterTest
public void tearDown() {
	driver.close();
	driver.quit();
	
}
	
}
