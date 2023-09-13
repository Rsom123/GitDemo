import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDemo 
{

	public static void main(String[] args)
	{
		
		
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/droppable/");
			
			System.out.println(driver.findElements(By.tagName("iframe")).size());
			
			// switchTo frame using WebElement
		//	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
			
			//switchTo frame using Index
			driver.switchTo().frame(0);
			
			//Using Actions class we can perform the action dragAndDrop
			Actions a= new Actions(driver);
			//Store the source and destination in a webElement
			WebElement Source= driver.findElement(By.id("draggable"));
			WebElement Destination= driver.findElement(By.id("droppable"));
			
			a.dragAndDrop(Source, Destination).build().perform();
			
			driver.switchTo().defaultContent();
			
			

	}

}
