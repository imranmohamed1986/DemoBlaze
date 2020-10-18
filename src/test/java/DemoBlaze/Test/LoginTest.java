package DemoBlaze.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/index.html");
		
	}
	
	
	@Test(priority=1)
	public void verifyTitle() {
		
		String Title = driver.getTitle();
		System.out.println("The Login Title Is: "+ Title);
		Assert.assertEquals(Title, "STORE");
		System.out.println("####################################################");
		
	}
	
	
	@Test(priority=2)
	public void verifyLoginCredentials() throws InterruptedException {
		
		driver.findElement(By.id("login2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("loginusername")).sendKeys("narmi7@yahoo.com");
		driver.findElement(By.id("loginpassword")).sendKeys("123456");
		driver.findElement(By.xpath("//div/button[text()='Log in']")).click();
		
		String text = driver.findElement(By.linkText("Welcome narmi7@yahoo.com")).getText();
		System.out.println("The Welcome Link is:" + text);
		boolean flag =driver.findElement(By.linkText("Welcome narmi7@yahoo.com")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println("#####################################################");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
}
