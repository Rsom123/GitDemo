import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators
{

	public static void main(String[] args) throws InterruptedException
	{
		String name="Rahul";
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("name");
		driver.findElement(By.name("inputPassword")).sendKeys("selenium");
		driver.findElement(By.className("signInBtn")).click();
		String s=	driver.findElement(By.cssSelector("p.error")).getText();
		
		System.out.println(s);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("name");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahul@rds.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("rahul@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1526485942");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String s1=	driver.findElement(By.cssSelector("form p")).getText();
		
		System.out.println(s1);
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[contains(@name,'Pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
		Thread.sleep(1000);
	
		String s2= driver.findElement(By.tagName("p")).getText();
		System.out.println(s2);
		Assert.assertEquals(s2,"You are successfully logged in.");
		
		String msg= driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "Hello Rahul,");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
		
	}

		
}
