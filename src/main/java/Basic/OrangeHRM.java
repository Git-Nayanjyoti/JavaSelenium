package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	/*
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		//printing the number of links
		System.out.println("The number of Links present in the site is:" + AllLinks.size());
		//printing the links
		System.out.println("\nThe links are:");
		for(int i = 0; i < AllLinks.size(); i++) {
			System.out.println(AllLinks.get(i).getAttribute("href"));	
		}
		//printing the link text
		System.out.println("\nThe link text are:");
		for(int i = 0; i < AllLinks.size(); i++) {
			System.out.println(AllLinks.get(i).getText());	
		}
		driver.close();
		
	} */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//a[@id=\"menu_admin_viewAdminModule\"]")).click();
		driver.findElement(By.xpath("//table//td//a")).click();
		System.out.println(driver.findElement(By.id("systemUser_chkChangePassword")).isDisplayed());
		System.out.println(driver.findElement(By.id("systemUser_chkChangePassword")).isEnabled());
		System.out.println(driver.findElement(By.id("systemUser_chkChangePassword")).isSelected());
		driver.quit();
	}
}
