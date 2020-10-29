package session55;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMTestconfigPropertiesFile {

	WebDriver driver;
	String browser = "chrome";

	@BeforeTest
	public void readConfig() {
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream(
					"C:\\SeleniumWinter2020\\objectyspy1.space\\src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println(browser);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void inIt() {

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

	// @Test(priority = 1)
	public void loginTest() throws InterruptedException {
		// Element Library
		By USER_NAME_FIELD = By.xpath("(//input[@class='form-control'])[1]");
		By PASSWORD_FIELD = By.xpath("//input[contains(@type, 'pass')]");
		By SIGNIN_BUTTON = By.xpath("//*[contains(@class, 'success block') and @type='submit']");
		By DASHBOARD_BUTTON = By.xpath("//span[contains(text(), 'Dashboard')]");
		// replace web element values by BY
		// 1.WebElement usernameField =
		// driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		// 2.WebElement passwordField =
		// driver.findElement(By.xpath("//input[contains(@type, 'pass')]"));
		// 3.WebElement signInButton = driver.findElement(By.xpath("//*[contains(@class,
		// 'success block') and @type='submit']"));

		// DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
		waitForElement(driver, 5, DASHBOARD_BUTTON);
		// Thread.sleep(2000)>replace it by explicitWait;
		// WebDriverWait wait = new WebDriverWait(driver, 5);

		String dashboardValidationText = driver.findElement(DASHBOARD_BUTTON).getText();
		Assert.assertEquals("Dashboard", dashboardValidationText, "Wrong Page!!!");
	}

	@Test
	public void addDepositTest() throws InterruptedException {
		// Element Library
		By USER_NAME_FIELD = By.xpath("(//input[@class='form-control'])[1]");
		By PASSWORD_FIELD = By.xpath("//input[contains(@type, 'pass')]");
		By SIGNIN_BUTTON = By.xpath("//*[contains(@class, 'success block') and @type='submit']");
		By DASHBOARD_BUTTON = By.xpath("//span[contains(text(), 'Dashboard')]");
		By CRM_BUTTON = By.xpath("//span[contains(text(), 'CRM')]");
		By ADD_CONTACT_BUTTON = By.xpath("//a[contains(text(), 'Add Contact')]");
		By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
		By COMPANY_NAME_FIELD = By.xpath("//input[@id='company']");
		By EMAIL_FIELD = By.xpath("//input[@id='email']");
		By PHONE_FIELD = By.xpath("//input[@id='phone']");
		By ADDRESS_FIELD = By.xpath("//input[@id='address']");
		By CITY_FIELD = By.xpath("//input[@id='city']");
		By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
		By ZIP_FIELD = By.xpath("//input[@id='zip']");
		By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary']");
		By LIST_CONTACTS_BUTTON = By.xpath("//a[contains(text(),'List Contacts')]");

		// login DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		// Test Data
		String fullName = "laureuwizeye";
		String companyName = "AutoEng";
		String emailAdress = "laureU@gmail.com";
		String phoneNumber = "7012640606";

		// Login
		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();

		// validate dashboard page?
		waitForElement(driver, 5, DASHBOARD_BUTTON);
		// Thread.sleep(2000)>replace it by explicitWait;
		// WebDriverWait wait = new WebDriverWait(driver, 5);

		String dashboardValidationText = driver.findElement(DASHBOARD_BUTTON).getText();
		Assert.assertEquals("Dashboard", dashboardValidationText, "Wrong Page!!!");

		// go to contact tab
		waitForElement(driver, 2, CRM_BUTTON);
		driver.findElement(CRM_BUTTON).click();
		waitForElement(driver, 2, ADD_CONTACT_BUTTON);
		driver.findElement(ADD_CONTACT_BUTTON).click();

		// Fill out add contact form
		Random rnd = new Random();
		int randomNum = rnd.nextInt(99);
		
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullName + randomNum);
		driver.findElement(COMPANY_NAME_FIELD).sendKeys(companyName + randomNum);

	}

//@Test(priority=2)
	public void loginTest1a() throws InterruptedException {
		// Element Library
		By USER_NAME_FIELD = By.xpath("(//input[@class='form-control'])[1]");
		By PASSWORD_FIELD = By.xpath("//input[contains(@type, 'pass')]");
		By SIGNIN_BUTTON = By.xpath("//*[contains(@class, 'success block') and @type='submit']");

		// DATA
		String loginId = "techfiosdemo@gmail.com";
		String password = "abc123";

		driver.findElement(USER_NAME_FIELD).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
		Thread.sleep(2000);

	}

	//@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();

	}

	private void waitForElement(WebDriver driver, int Seconds, By dASHBOARD_BUTTON) {
		Object timeInSeconds;
		WebDriveWait wait = new WebDriveWait();

	}

}
