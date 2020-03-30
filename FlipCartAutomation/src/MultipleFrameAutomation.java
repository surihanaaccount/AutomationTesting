import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFrameAutomation {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		driver.manage().window().maximize();
		
	    driver.switchTo().frame("main");
	    
	    List<WebElement> h2TitleTags=driver.findElements(By.cssSelector("body > h2"));
	    
	    for(WebElement h2Tag : h2TitleTags)
	    {
	    	System.out.println("The Title tag is "+h2Tag.getText());
	    	if(h2Tag.getText().contains("Title bar"))
	    	{
	    		break;
	    	}
	    }
	    
	    driver.switchTo().parentFrame();
	    
	    driver.switchTo().frame("navbar");
	    
	    String childLeftFrameText=driver.findElement(By.cssSelector("body > h3")).getText();
	    
	    System.out.println(childLeftFrameText);
	    
	}

}
