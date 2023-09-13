import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleAssignment 
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows=	driver.getWindowHandles();
		Iterator<String> it=	windows.iterator();
		String ParentID= it.next();
		String ChildId= it.next();
		
		driver.switchTo().window(ChildId);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
		
		driver.switchTo().window(ParentID);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.quit(); 

	}

}
