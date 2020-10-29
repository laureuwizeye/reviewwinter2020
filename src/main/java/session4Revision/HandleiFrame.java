package session4Revision;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleiFrame {
	
	
	@Test
	public void handleiFrames() {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWinter2020\\objectyspy1.space\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	// Go to the Oracle site
	// click on the java.awt.color link
	// Click on the ColorSpace link
	// Click on the Serializable link
	// validate "Interface Serializable" showed

	driver.get("https://docs.oracle.com/javase/8/docs/api/");
	// switch by index
	// driver.switchTo().frame(0);
	// switch by name
	driver.switchTo().frame("packageListFrame");

	driver.findElement(By.linkText("java.awt.color")).click();

	// move the driver to the default location
	driver.switchTo().defaultContent();

	// switch to frame #2 with index
	driver.switchTo().frame(1);
	// explicit wait on the following element before lick
	waitForElement(driver, 40, By.linkText("ColorSpace"));
	driver.findElement(By.linkText("ColorSpace")).click();

	driver.switchTo().defaultContent();
	driver.switchTo().frame(2);
	driver.findElement(By.linkText("Serializable")).click();
	}

	//Explicit wait encapsulated in a method
	private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
	WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));
	
	
	}
	
}
