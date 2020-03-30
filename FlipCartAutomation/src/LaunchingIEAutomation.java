import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchingIEAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "D:\\Softwares\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
	    //driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		Thread.sleep(30000);
		
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	    
	    WebElement giftCard= driver.findElement(By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[2]/div/div[3]/a/span"));
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,"+giftCard.getLocation().x+")");
	    
	    new Actions(driver).moveToElement(giftCard).click().perform();
		
		//giftCard.click();
		
		Thread.sleep(30000);
		
		driver.close();
	}

}
