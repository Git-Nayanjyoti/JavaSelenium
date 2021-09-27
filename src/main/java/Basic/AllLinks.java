package Basic;
import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("all tags are " + alltags.size());
		
		for (int i =0;i<alltags.size();i++) {
			
			System.out.println("all links on this page are listed below "+ alltags.get(i).getAttribute("href"));
		}
		

	}

}