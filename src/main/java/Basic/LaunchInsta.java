package Basic;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchInsta {

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
			driver.get("https://www.instagram.com");
			((WebElement) driver.findElements(By.xpath("//*[starts-with(@id=\"loginForm\")]/div/div[1]/div/label/input"))).sendKeys("username");
			((WebElement) driver.findElements(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"))).sendKeys("password");
			driver.findElement(By.linkText("Log In")).click();
			Thread.sleep(3000);
			driver.close();
			
		}

}
