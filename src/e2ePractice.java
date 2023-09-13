import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2ePractice
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Pictures\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Auto Suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options=	driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
					{
						option.click();
						break;
					}
		}
		
		
		
		  Thread.sleep(2000); // Dyanamic dropdown
		  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		  driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).
		  click(); driver.findElement(By.xpath("//a[@value='PNQ']")).click();
		  driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		  
		  Thread.sleep(2000); //element is enabled or disabled
		  driver.findElement(By.className("ui-state-default")).click();
		  
		  if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		  { 
			  Assert.assertTrue(true); 
			  System.out.println("It's Disabled");
		  }
		  else
		  {
		  Assert.assertFalse(false); 
		  }
		  
		  driver.findElement(By.id("ui-datepicker-div")).click();
		  driver.findElement(By.className("paxinfo")).click(); Thread.sleep(2000);
		  //no.of passengers click on plus icon(Updated Dropdown)
		  
		  for(int i=1;i<5;i++)
		  {
			  driver.findElement(By.id("hrefIncAdt")).click();
		  }
		  
		  driver.findElement(By.id("btnclosepaxoption")).click(); 
		  String count=driver.findElement(By.className("paxinfo")).getText();
		  System.out.println(count);
		  Assert.assertEquals(driver.findElement(By.className("paxinfo")).getText(),"5 Adult");
		  
		  //static dropdown using select class 
		  WebElement E=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		   Select dropdown= new Select(E); dropdown.selectByVisibleText("AED");
		  
		  //check box select and click
		  driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		  boolean b= driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected();
		   System.out.println(b);
		   
		   //click on search button
		   
		   driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		
		driver.close();
	}

}
