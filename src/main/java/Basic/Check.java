package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Check {
	static WebDriver driver;
	static WebElement busHireOptions;

	public static void main(String[] args) throws InterruptedException { 

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");  
		driver.findElement(By.id("redBus Bus Hire")).click();
		busHireOptions = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(busHireOptions);
 
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(
				"Hotel Taj, Maharashtra Nagar Road, Bhandup, Maharashtra Nagar, Kanjurmarg West, Bhandup West, Mumbai, Maharashtra, India");
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElement(By.xpath("/html/body/ul[2]")).findElements(By.tagName("li"));
		for (int i = 0; i < options.size(); i++) {
			List<WebElement> spans =options.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals("Hotel Taj, Maharashtra Nagar Road, Bhandup, Maharashtra Nagar, Kanjurmarg West, Bhandup West, Mumbai, Maharashtra, India")) {
				spans.get(1).click();
			}
		} 
		Thread.sleep(3000);
  
		driver.quit();
	}  

}
