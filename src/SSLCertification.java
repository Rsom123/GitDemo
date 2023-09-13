import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertification 
{

	public static void main(String[] args) 
	{
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
