import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvokeMultipleTab 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\RAHUL\\Automation Pratice\\SeleniumDemo\\driver\\chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		option.setBinary("C:\\Users\\RAHUL\\ChromeDriver\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// open new window or tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		// switching the winodows
		Set<String> WindowHandle= driver.getWindowHandles();
		Iterator it=	WindowHandle.iterator();
		String parentWindowID = (String) it.next();
		String ChildWindowID=	(String) it.next();
		
		driver.switchTo().window(ChildWindowID);
		driver.get("https://rahulshettyacademy.com/");
		String CourseName=	driver.findElement(By.xpath("//a[contains(text(),'All-Access Membership-Complete Access to 25+ Cours')]")).getText();
		driver.switchTo().window(parentWindowID);
		WebElement nameField=	driver.findElement(By.cssSelector("input[name='name']"));
		nameField.sendKeys(CourseName);
		
		// get ScreenShot of perticular webelement
		File file=	nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		// to get the hight and width of webelement
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
		driver.quit();
		
	}

}
