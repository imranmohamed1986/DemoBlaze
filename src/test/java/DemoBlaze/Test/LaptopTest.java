package DemoBlaze.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaptopTest {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.demoblaze.com/");
		
	}

	@Test(priority=1)
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
	
		@Test(priority=2)
		public void Laptops() throws InterruptedException {
			
			driver.findElement(By.linkText("Laptops")).click();
			
			driver.findElement(By.linkText("2017 Dell 15.6 Inch")).click();
			
			driver.findElement(By.linkText("Add to cart")).click();
			Thread.sleep(3000);
			driver.switchTo().alert();
			Thread.sleep(3000);
			String AlertText = driver.switchTo().alert().getText();
			Thread.sleep(3000);
			
			System.out.println("The Alert Messaged Is: " +AlertText);
			
			driver.switchTo().alert().accept();
			
			Assert.assertEquals(AlertText, "Product added.", "TestCase is Pass");
			
			System.out.println("##################################################");
			
		}
	
	
	@Test(priority=3)
	public void verifyCartLink() throws InterruptedException {
		
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"page-wrapper\"]/div/div/h2[text()='Products']")).isDisplayed());
		System.out.println("##################################################");
	}
	
	
	@Test(priority=4)
	public void placingOrder() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("moe Imran");
		driver.findElement(By.id("country")).sendKeys("United States");
		driver.findElement(By.id("city")).sendKeys("New York");
		driver.findElement(By.id("card")).sendKeys("1234567891234567");
		driver.findElement(By.id("month")).sendKeys("March");
		driver.findElement(By.id("year")).sendKeys("1986");
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(3000);
		String ConfirmationText =driver.findElement(By.xpath("//div[@class='sa-icon sa-success animate']")).getText();
		Thread.sleep(3000);
		System.out.println("The Product Confirmation Text Is: "+ ConfirmationText);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='sa-icon sa-success animate']")).isDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
		Thread.sleep(3000);
		System.out.println("#####################################################");
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
