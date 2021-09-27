package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		WebElement dropDown = driver.findElement(By.id("searchLanguage"));
		
		//TC to check if the title is displayed correctly
		String expectedTitle = "Wikipedia India";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}
		
		Select select = new Select(dropDown);
		//select.selectByVisibleText("Italiano");
		select.selectByValue("it");
		Thread.sleep(4000);
		
		dropDown.findElements(By.tagName("option"));
		System.out.println(driver.findElements(By.tagName("option")).size());
		List<WebElement> options = driver.findElements(By.tagName("option"));
		
		
		for (WebElement webElement : options) {
			//System.out.println(webElement.getText());
			System.out.println(webElement.getAttribute("lang"));
		}
		
		//isdisplayed, isselected, isenabled
		
		
		
		driver.quit();
		
		
		
	}
}