package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wikipedia {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.findElement(By.id("searchLanguage")).sendKeys("en");
		//test case for Title is displayed correctly
		String expectedTitle = "Wikipedia";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle )) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}
		List<WebElement> options = driver.findElements(By.tagName("option"));
		System.out.println("The no of options available is: " + options.size());
		
		System.out.println("The attribute of the options are:");
		for(WebElement webElement : options) {
			System.out.println(webElement.getAttribute("lang"));
		}
		System.out.println("The text of the options are:");
		for(WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
