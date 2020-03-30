import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarMakeMytrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\parveen\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		
		WebElement departCal=driver.findElement(By.xpath("//label[@for='departure']/span"));
		
		selectDate(departCal,"2020","September", "22", driver);
		
		//Note: http://makeseleniumeasy.com/2017/09/18/how-to-handle-different-types-of-calendars-in-selenium-part-1/
		
	}

	private static void selectDate(WebElement departCal, String yearName, String monthName, String day,
			WebDriver driver) throws InterruptedException {
	
		
		departCal.click();
		
		String Year=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText();
		
		
		
		String[] split=Year.split(" ");
		
		String currentYear=split[1];
		String currentMonth=split[0];
				
		
		System.out.println("The current Year is "+currentYear);
		
		//*[@aria-label='Next Month']
		
		if(!currentMonth.equalsIgnoreCase(monthName))
		{
			do
			{
			driver.findElement(By.xpath("//*[@aria-label='Next Month']")).click();
			}
			while(!driver.findElement(By.xpath("//*[@class='DayPicker-Caption']/div")).getText().contains(monthName));
		}
		
		
		List<WebElement> daysRows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']"));
		
		System.out.println(daysRows.size());
		
		for(int i=0;i<daysRows.size();i++)
		{
			List<WebElement> rows=driver.findElements(By.xpath("//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']["+i+"]//*[@class='dateInnerCell']/p"));
			
			System.out.println(rows.size());
			
			for(int j=0;j<rows.size();j++)
			{
				System.out.println(rows.get(j).getText());
				if(rows.get(j).getText().equals(day))
				{
					rows.get(j).click();
					break;
				}
			}
		}
		
		
		Thread.sleep(30000);
		
		driver.close();

		
	}

}
