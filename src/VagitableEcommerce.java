import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VagitableEcommerce 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String[] ItemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> Products=	driver.findElements(By.xpath("//div[@class='product-action']/button"));
		
		//
		for(int i=0;i<Products.size();i++)
		{
			// split it to get actual vegetable name
			//Cucumber - 1 Kg
			String[] name=Products.get(i).getText().split("-");
			String SplitName= name[0].trim();
			
			//convert array into arraylist for easy serach
			//check weather name you extracted is present in array or not
			
			List<String> ItemsNeededList = Arrays.asList(ItemsNeeded);
			
			
			if(ItemsNeededList.contains(SplitName))
			{
				
				//click on add to cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();	
				
			}
			
		}
		driver.close();
	}

}
