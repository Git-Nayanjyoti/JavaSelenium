package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {

	/*
	 * How to identify an element
	 * anything which is displayed on the UI, is called as a WebElement
	 * finding an element will return a webelement
	 * 
	 * Webelements
	 * id >> priority 1
	 * name >> priority 2 
	 * class name --not prefered
	 * xpath >> priority 3
	 * Full
	 * /html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input
	 * 
	 * Copy Xpath
	 * //*[@id="email"]
	 * 
	 * css >> priority 3
	 * #pass
	 * 
	 * tagname - not recommended
	 * 
	 * URL
	 * linktext - priority1 - exact match
	 * partiallinktext - priority2
	 * username >> Shilpa
	 * Forgotten password Shilpa?
	 * 
	 * Xpath
	 * findElement
	 * findElements
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("username");
		driver.findElement(By.cssSelector("#pass")).sendKeys("Password");
		driver.findElement(By.partialLinkText("Forgotten")).click();
		
	
		//driver.findElement(By.linkText("Forgotten")).click();
		Thread.sleep(4000);
		
		driver.quit();
		
	}
}