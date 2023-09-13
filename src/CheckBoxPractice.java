import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxPractice
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Assert.assertFalse(	driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
	int size=	driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		
		System.out.println(size);
		
		driver.close();
		

	}

}
