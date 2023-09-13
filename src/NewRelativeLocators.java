import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*; // it's not autosuggest package, need to enter manually

import org.openqa.selenium.By;

public class NewRelativeLocators 
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox=	driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(driver.findElement((with(By.tagName("label")).above(nameEditBox))).getText());
		
		WebElement Gender=	driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement((with(By.tagName("input")).below(Gender))).click();	
		
		WebElement rdb=	driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement((with(By.tagName("label")).toRightOf(rdb))).getText());	
		
		WebElement IceCream=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement((with(By.tagName("input")).toLeftOf(IceCream))).click();
		
		//driver.close();
		
		
	}

}
