import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeForm 
{

	public static void main(String[] args) 
	{
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Rahul Somwanshi");
		driver.findElement(By.name("email")).sendKeys("ABS@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ABS@123");
		driver.findElement(By.id("exampleCheck1")).click();
	WebElement dropdown=	driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select Gender= new Select(dropdown);
		Gender.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("03/05/1993");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	String text=	driver.findElement(By.xpath("//div/div[@class='alert alert-success alert-dismissible']")).getText();
		 
		System.out.println(text);
			
	}

}
 