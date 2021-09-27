package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames present is " +frames.size());
		//switching to frames
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("tinymce")).sendKeys("Nayan");
		Thread.sleep(4000);
		//switching back to main window
		driver.switchTo().parentFrame();
		driver.quit();
		
	}
}