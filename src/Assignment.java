import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. click on check box and grabbed the text
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
		driver.findElement(By.xpath("//label[@for='benz']")).getText();
		String opt= driver.findElement(By.xpath("//label[@for='benz']")).getText();
		WebElement dropdown= driver.findElement(By.id("dropdown-class-example"));
		
		Select s= new Select(dropdown);
		s.selectByVisibleText(opt);
		
		driver.findElement(By.id("name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		
		
		String text=driver.switchTo().alert().getText();
		
		if(text.contains(opt))
		{
			System.out.println("Alert msg Success");
		}
		else
		{
			System.out.println("Something went Wrong");
		}
		
		
	}

}
