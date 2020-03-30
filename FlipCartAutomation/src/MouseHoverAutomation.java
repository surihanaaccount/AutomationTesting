import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAutomation {
	
public static void main(String[] args) throws InterruptedException {
       
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.boschtools.com/us/en/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[class='wowPopover__closeButton']")).click();
		
		WebElement mainMenu = driver.findElement(By.linkText("Products"));
		
        Actions action=new Actions(driver);
		
		action.moveToElement(mainMenu).perform();
		
		WebElement subMenu = driver.findElement(By.linkText("Cordless Combo Kits"));
		
		//subMenu.click();
		
		action.contextClick(subMenu).click().build().perform();
		
		//action.moveToElement(subMenu).click().build().perform();
		
		Thread.sleep(30000);
		
		driver.close();
		
}
}
