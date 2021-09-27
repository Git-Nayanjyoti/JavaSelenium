import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Blackbaze {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.backblaze.com/");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.id("b2")).click();
		driver.findElement(By.xpath("//*[@id=\"header-content\"]/div/div/div[1]/div[2]/div/div/a[7]")).click();
		
		
	}

}
