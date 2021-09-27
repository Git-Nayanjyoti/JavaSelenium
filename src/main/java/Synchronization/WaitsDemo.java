package Synchronization;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	/*
	 * Waits: sometimes it may happen that webdriver is trying to access an element
	 * and the element is not loaded/visible on the page yet
	 * 
	 * so we need to slow down or wait till the element is loaded/visible
	 * Pageloadtimeout Waits for the page to load
	 * 
	 * Thread.sleep
	 * 
	 * Two types of waits 1. Implicit: applies on all the elements on the page 2.
	 * Explicit: is defined for some expected condition for a specific element
	 * 
	 * 
	 * all elements >> 5 seconds >> implicit wait of 5 seconds one element >> 12
	 * seconds >> explicit wait for specific element
	 * 
	 * element loading time: 10, 7, 2
	 * 
	 * thread sleep 10 seconds: 10, 10, 10
	 * 
	 * class >> for 3 element >> sleep for 10 seconds 100 class > 0.5 minute * 100;
	 * implcat wait 10 seconds: 10, 7, 2
	 * 
	 * Fluent wait
	 * 
	 * 45 seconds fluent wait
	 * 
	 */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// wait for the page to load
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// wait for the elements on the page to load before throwing an error
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.name("identifier")).sendKeys("ajay.m191987@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		// before the password field is displayed, we are trying to access it

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement password;
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.click();

		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(45))
				.pollingEvery(Duration.ofSeconds(5))//in how many seconds you want to check if element is present or not
				.ignoring(NoSuchElementException.class);

		driver.findElement(By.name("password")).sendKeys("testpassword");

	}
}