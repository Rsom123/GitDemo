import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calender
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//month name and date
		// selecting the date
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		List<WebElement> dates=	driver.findElements(By.cssSelector(".flatpickr-day"));
		int count=	driver.findElements(By.cssSelector(".flatpickr-day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text= driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			 
			if(text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}
			
		}
		

	}

}
