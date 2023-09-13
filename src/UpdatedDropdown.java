import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		boolean select1=	driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
		System.out.println(select1);
		
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
	boolean select=	driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected();
		System.out.println(select);
		
	int checkboxSize=	driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		System.out.println(checkboxSize);
		
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//driver.findElement(By.id("hrefIncAdt")).click(); // to click on plus icon 5 times
		
		/*
		 * int i=1; while(i<6) { driver.findElement(By.id("hrefIncAdt")).click(); i++; }
		 */
		
		for(int i=1;i<6;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.close();
		
	}

}
