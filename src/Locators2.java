import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password= GetPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[contains(@name,'Pass')]")).sendKeys(password);
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

	public static String GetPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PasswordText= driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passArray= PasswordText.split("'");
		
		//0th index- Please use temporary password 
		//1st index- rahulshettyacademy' to Login.
		
		String Password= passArray[1].split("'")[0];
		return Password;
		
		//0th index- rahulshettyacademy
		//1st index- ' to Login.
		
	}
}
