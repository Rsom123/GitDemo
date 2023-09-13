import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinksCount2 
{

	public static void main(String[] args) 
	{
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement FooterSection=driver.findElement(By.id("gf-BIG"));
		
		System.out.println(FooterSection.findElements(By.tagName("a")).size());		
		
		WebElement Coloum=	FooterSection.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul[1]"));
		System.out.println(Coloum.findElements(By.tagName("a")).size());
		
		for(int i=1;i<Coloum.findElements(By.tagName("a")).size();i++)
		{
			String Click=	Keys.chord(Keys.CONTROL,Keys.ENTER);
			Coloum.findElements(By.tagName("a")).get(i).sendKeys(Click);
			
		}
		
		Set<String> Windows =driver.getWindowHandles();
		
		Iterator it=	Windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window((String) it.next());
			System.out.println(driver.getTitle());
			
		}
		
		driver.quit();
	}

}
