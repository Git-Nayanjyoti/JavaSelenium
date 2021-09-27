package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAmazon {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Test Login feature:
		 * 1. Open Chrome Browser
		 * 2. Launch the appplication
		 * 3. Enter username
		 * 4. Enter password
		 * 5. CLick on LogIn
		 * 6. Close browser
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amzn.to/3EMovJx");
		driver.findElement(By.id("ap_email")).sendKeys("anonymous@gmail.com");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		driver.close();
	}


}
