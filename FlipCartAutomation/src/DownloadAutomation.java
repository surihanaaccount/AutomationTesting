import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver;
		
		String downloadFilepath="D:\\Softwares";
		
		HashMap<String,Object> chromePrefereces=new HashMap<String,Object>();
		
		chromePrefereces.put("profile.default_content_settings.popups", 0);
		chromePrefereces.put("download.default_directory", downloadFilepath);
		
		ChromeOptions options=new ChromeOptions();
		
		options.setExperimentalOption("prefs", chromePrefereces);
		options.addArguments("--test-type");
	    options.addArguments("--disable-extensions");
	    
	    DesiredCapabilities cap=DesiredCapabilities.chrome();
	    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    cap.setCapability(ChromeOptions.CAPABILITY, options);
	    
	    driver=new ChromeDriver(cap);
	    
	    driver.get("https://www.selenium.dev/downloads/");
	    
	    driver.findElement(By.linkText("32 bit Windows IE")).click();
	    
	    
		

	}

}
