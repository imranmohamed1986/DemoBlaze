package DemoBlaze.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test(priority=0)
	public void verifyingProductstorelink() {
	
		
		Assert.assertTrue(driver.findElement(By.id("nava")).isDisplayed());
		String VerifyLink = driver.findElement(By.id("nava")).getText();
		System.out.println("The Product Link Is: "+VerifyLink );
		
	}
		
		
	@Test(priority=1)
	public void verifyLoginForm() throws InterruptedException {
		
		driver.findElement(By.id("signin2")).click();
		Thread.sleep(3000);
		
	
		driver.findElement(By.id("sign-username")).sendKeys("narmi7@yahoo.com");
		driver.findElement(By.id("sign-password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		String signupMessage = driver.switchTo().alert().getText();	
		System.out.println("The SignUp Alert Message is:" + signupMessage );
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(signupMessage, "Sign up successful.", "Test Is Pass");
		System.out.println("###########################################################");
	}
		
		
	
		
		
		
		
		

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  @AfterTest 
	  public void tearDown() {
	  
	  driver.quit();
	  
	  }
	 
	
	
	

}