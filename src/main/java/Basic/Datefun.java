package Basic;

import java.util.List;

import org.apache.velocity.runtime.directive.Parse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datefun {
	static WebDriver driver;
	static int monthIndex = 10;
	static int day = 9;
	
	static String[] months = {"Jan","Feb","Mar","Apr","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    
	public static void datepicker() throws InterruptedException {
		int year = 2021;
		// Date enter operations
		/*
		 * Thread.sleep(5000); String[] d = date.split("/");
		 * 
		 * for (int i = 0; i < d.length; i++) System.out.println(d[i]);
		 */
		
		String MonthYear = months[monthIndex] + " " + year;
		System.out.println(MonthYear);
		WebElement initialDate = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div/p"));
			while(initialDate.getText() != MonthYear) {
				List<WebElement> next = initialDate.findElements(By.tagName("button"));
				next.get(2).click();
			}
	
	} 

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.id("redBus Bus Hire")).click();
		int items = 0;
		WebElement busHireOptions = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(busHireOptions);

		WebElement temp = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]"));
		List<WebElement> options = temp.findElements(By.tagName("div"));
		Thread.sleep(2000);
		for (items = 0; items < options.size(); items++) {
			if (options.get(items).getText().equals("Outstation")) {
				options.get(items).click();
 
				Thread.sleep(2000);
				// driver.findElement(By.id("round_trip")).click();
				driver.findElement(By.id("locationTextFieldLocal")).sendKeys(
						"Hotel Taj, Maharashtra Nagar Road, Bhandup, Maharashtra Nagar, Kanjurmarg West, Bhandup West, Mumbai, Maharashtra, India");
				Thread.sleep(2000);

				List<WebElement> listItem = driver.findElement(By.xpath("/html/body/ul[2]"))
						.findElements(By.tagName("li"));
				// System.out.println(listItem.size()); 
				for (int i = 0; i < listItem.size(); i++) {

					List<WebElement> span = listItem.get(i).findElements(By.tagName("span"));
					if (span.get(1).getText().equals(
							"Hotel Taj, Maharashtra Nagar Road, Bhandup, Maharashtra Nagar, Kanjurmarg West, Bhandup West, Mumbai, Maharashtra, India")) {
						span.get(1).click();
					}

				}

			}
		}

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/div[1]/div[2]/div[2]/div/div/div/input")).click();
		try {
			datepicker();
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
 
	}

}
