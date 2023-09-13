import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment 
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement MiddleFrame= driver.findElement(By.xpath("//body/div[@id='content']"));
		String middletext= MiddleFrame.getText();
		System.out.println(middletext);
		
		

	}

}
