import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class siblingXpathTravers 
{

	public static void main(String[] args) 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//parent to child sibling followed by sibling
		//header/div/button[2]/following-sibling::button
		
		String BtnText= driver.findElement(By.xpath("//header/div/button[2]/following-sibling::button")).getText();
		System.out.println(BtnText);
		
		// now traverse from child to parent also
		
		//header/div/button[2]/parent::div/parent::header
		
		String s= driver.findElement(By.xpath("//header/div/button[2]/parent::div/button[2]")).getText();
		System.out.println(s);
		driver.close();
	}

}
