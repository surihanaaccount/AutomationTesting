import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class FlipkartAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	    
	    //WebElement giftCard= driver.findElement(By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[2]/div/div[3]/a/span"));
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,"+giftCard.getLocation().x+")");
		
		//giftCard.click();
	    
	    WebElement women=driver.findElement(By.cssSelector("._114Zhd>li:nth-child(4)"));
	    
	    WebElement enthnicWear=driver.findElement(By.cssSelector("._114Zhd>li:nth-child(4)>ul>li>ul>li:nth-child(2)>ul>li:nth-child(1)"));
	    
	    Actions action=new Actions(driver);
	    
	    action.moveToElement(women).moveToElement(enthnicWear).click().build().perform();
	    
	    Thread.sleep(30000);
		
		//driver.close();
		
		
		
		
        
		

		
       }

}

