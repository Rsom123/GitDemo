import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks 
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		//Broken URL
		// step 1: is to get all URL's tied up to the links using selenium
		// java methods will call URL's and get you the status code
		// if status code is > 400 then, that url is not working--> links which tied to url is broken
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links=	driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a= new SoftAssert();
		
		for(WebElement link: links)
		{
			String url=	link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			int respCode=	conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text" +link.getText()+ "is broken with code" +respCode);
			
		}
			a.assertAll();
		
			driver.close();
		 
	}

}
