import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		/*
		 * boolean select1=
		 * driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
		 * System.out.println(select1);
		 */
		
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		/*
		 * boolean select=
		 * driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
		 * System.out.println(select);
		 */
		
	int checkboxSize=	driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		System.out.println(checkboxSize);
		driver.close();

	}
	
	
}
