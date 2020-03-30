import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RangeSliderAutomation {

	public static void main(String[] args) {
       
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/resources/demos/slider/range.html");
		
		WebElement initialPoint=driver.findElement(By.cssSelector("#slider-range > span:nth-child(2)"));
		
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		
		action.clickAndHold(initialPoint);
		action.moveByOffset(58, 582).build().perform();
		

	}

}
