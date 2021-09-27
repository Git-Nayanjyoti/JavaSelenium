package Basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.id("txtUsername"));
		actions.moveToElement(username)
		.click()
		.keyDown(Keys.SHIFT)
		.sendKeys("hello")
		.keyUp(Keys.SHIFT)
		.doubleClick()
		.build()
		.perform();
		
		Thread.sleep(4000);
		driver.quit();
		
	}
}