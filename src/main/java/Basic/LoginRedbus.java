package Basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginRedbus {
 

	static WebElement driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://redbus.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("i-icon-profile")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("signInLink")).click(); 
		Thread.sleep(2000);
		WebElement frame = driver.findElement(By.className("modalIframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(4000); 
		 
		driver.findElement(By.id("newFbId")).click();
		 
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> winList = windows.iterator();
		while(winList.hasNext()) {
			String childWindow = winList.next(); 
			if(!parent.equals(childWindow)) {
				driver.switchTo().window(childWindow); 
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys("icansoyoucan50@gmail.com");
				Thread.sleep(2000);  
				driver.findElement(By.id("pass")).sendKeys("12345@Qwerty"); 
				 
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[4]/label[2]/input")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div/div[2]/div[1]/div[2]/div[1]/button")).click();
				
				Thread.sleep(5000);
				//driver.close();
			} 
		}
		//driver.switchTo().window(parent);
		
		//driver.quit();
		
		
	} 

}
