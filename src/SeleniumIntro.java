import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro 
{

	public static void main(String[] args)
	{
		//Invoking into browser
		
		// chrome browser- ChromeDriver/fireFox and others is class which is having some method to do the automate
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
 		String S = driver.getTitle();
 		System.out.println(S);
 		String s1= driver.getCurrentUrl();
		System.out.println(s1);
		
		driver.close();
		driver.quit();
		
		//FireFox Driver
		
		 
		
		

	}

}
