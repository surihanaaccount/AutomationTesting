import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameAutomatopm {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		driver.manage().window().maximize();
		
	    driver.switchTo().frame("a077aa5e");
	    
	    WebElement imgElement=driver.findElement(By.cssSelector("img[src='Jmeter720.png']"));
	        
	    Actions action=new Actions(driver);
	    action.contextClick(imgElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	    
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector("#philadelphia-field-email")).sendKeys("abcd@gmail.com");
	    
	    
	}

}
