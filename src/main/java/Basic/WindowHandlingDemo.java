package Basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		//every window has a unique handle id
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent ID is "+ parentWindow);
		driver.findElement(By.id("button1")).click();
		//2 windows are open, but driver is pointing to parent
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);
			//compare this value to parent window
			//if its same do nothing
			//if its not same, save it as child window
		}
		
		//way 1
		System.out.println("Printing using Iterator");
		Iterator<String> it = windowHandles.iterator();
		//System.out.println(it.next());
		String childWindow = it.next();
		
		String pTitle = driver.getTitle();
		System.out.println("Parent Window title is "+ pTitle);
		
		driver.switchTo().window(childWindow);
		String cTitle = driver.getTitle();
		System.out.println("Child Window title is "+ cTitle);
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}