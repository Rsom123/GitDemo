import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCount
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Get the count of the links present on webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Get the size of the links i.e present in footer section only
		WebElement FooterLinks= driver.findElement(By.id("gf-BIG"));
		System.out.println(FooterLinks.findElements(By.tagName("a")).size());
		
		// get the count of the links in first coloum of footer section
		
		WebElement ColoumnLinks=	FooterLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	
		System.out.println(ColoumnLinks.findElements(By.tagName("a")).size());
		
		//click on each link in the coloum and check if the pages are opening
		
		for(int i=1;i<ColoumnLinks.findElements(By.tagName("a")).size();i++)
		{
			String ClickOnTab=	Keys.chord(Keys.CONTROL,Keys.ENTER);
			ColoumnLinks.findElements(By.tagName("a")).get(i).sendKeys(ClickOnTab);
			Thread.sleep(5000);
		}
		
			//Get the Title of each and every page
			Set<String>	abc= driver.getWindowHandles();
			Iterator it=	abc.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window((String) it.next());
				System.out.println(driver.getTitle());
			}
			
		}
		 

	}


