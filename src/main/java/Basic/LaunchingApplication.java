package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingApplication {

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
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("username");
		driver.findElement(By.name("pass")).sendKeys("password");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.close();
	}
}