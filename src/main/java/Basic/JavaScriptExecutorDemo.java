package Basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 1000)");
		/*
		 * x-pixels: defines the x-axis
		 * it moves to the left if number is positive
		 * it moves to the right if number is negative
		 * 
		 * y - pixels: defines the y-axis
		 * it moves down if the number is positive
		 * it moves up if the number is negative
		 */
		
		//moving to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
		WebElement element = null;
		//scrolling to a specific element
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(10000);
		
		//click on btton using JS
		js.executeScript("arguments[0].click();", element);
		driver.quit();
		
		
	}
}