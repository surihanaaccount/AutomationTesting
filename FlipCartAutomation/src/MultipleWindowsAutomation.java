import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.naukri.com/");
		
		String mainWindow=driver.getWindowHandle();
		
		Set<String> childWindows=driver.getWindowHandles();
		
		Iterator<String> itr=childWindows.iterator();
		
		while(itr.hasNext())
		{
			String childWindow = itr.next();
			
			if(!mainWindow.equals(childWindow))
			{
				//driver.switchTo().window(childWindow);
				
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				
				if((driver.switchTo().window(childWindow).getTitle()).equalsIgnoreCase("Amazon"))
						{
					driver.switchTo().window(childWindow);
					
					//driver.manage().window().maximize();
					
					Thread.sleep(30000);
					
					
						}
				
				 driver.close();
				
				
			}
		}
		
		
		driver.switchTo().window(mainWindow);
		
		

	}

}
