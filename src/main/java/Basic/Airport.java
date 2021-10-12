package Basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Airport {

	static WebDriver driver;

	
	public static void dateAndTime(String date, String time) throws InterruptedException, ParseException {

		//for date
		String[] timeArr = time.split(":");
		String hour = timeArr[0];
		String minute = timeArr[1];
		System.out.println(hour);
		System.out.println(minute);
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1]; 
		Date currentDate = new Date();
		String formatDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1; 
				formatDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatDate);
		if (inputDate.before(currentDate)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			System.out.println(MonthYear);
			Thread.sleep(3000);
			
			while (!driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div/p"))
					.getText().equalsIgnoreCase(MonthYear)) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[2]"))
						.click();
			}
 
			List<WebElement> size = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[1]"))
					.findElements(By.tagName("div"));
			System.out.println(size.size());

			for (int i = 1; i < size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver.findElement(By.xpath(
							"/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[" + i + "]/div[" + j + "]"));
					if (MonthYear == "February 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						// System.out.println(findDate.getText());
						findDate.click();
						i = 0;
						break;
					}
				}
				if (i == 0) {
					break;
				}

			}
			//For time
			List<WebElement> hourHand = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div/div"))
					.findElements(By.tagName("span"));
			System.out.println(hourHand.size());
			Thread.sleep(3000);
			for (int hrs = 0; hrs < hourHand.size(); hrs++) {
				if (hourHand.get(hrs).getText().equals(hour)) {
					Thread.sleep(3000); 
					WebElement cor1 = hourHand.get(hrs);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor1).click().perform();
					cor1 = null;
					break; 

				}
			}
			Thread.sleep(3000);
			List<WebElement> secondHand = driver 
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div/div"))
					.findElements(By.tagName("span"));
			System.out.println(secondHand.size());
			Thread.sleep(3000);
			for (int min = 0; min < secondHand.size(); min++) {
				if (secondHand.get(min).getText().equals(minute)) {
					Thread.sleep(3000); 
					WebElement cor2 = secondHand.get(min);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor2).click().perform();
					cor2 = null;
					break;
					
				}
			} 
			driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]")).click();

		}

	}

	public static void main(String[] args) throws InterruptedException, ParseException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("redBus Bus Hire")).click();
		WebElement frame = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]")).click();
		Thread.sleep(3000);
 
		
		driver.findElement(By.id("numberOfPax")).sendKeys("55");
		driver.findElement(By.className("select-selected")).click();
		List<WebElement> select = driver.findElement(By.className("select-items"))
				.findElements(By.className("select-item"));

		for (int item = 0; item < select.size(); item++) {
			if (select.get(item).getText().equals("Hyderabad")) {
				select.get(item).click();
			}
		} 
		
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(
				"Mumbai Masalaa - Narayanguda, Chitrapuri Colony, Bagh Lingampalli, Narayanguda, Hyderabad, Telangana, India");
		Thread.sleep(3000);

		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(
					"Mumbai Masalaa - Narayanguda, Chitrapuri Colony, Bagh Lingampalli, Narayanguda, Hyderabad, Telangana, India")) {
				spans.get(1).click();
			} 
		} 
		
		Thread.sleep(3000);
		driver.findElement(By.id("from_datepicker")).click();
		Thread.sleep(3000);
		dateAndTime("14-November-2021", "12:15");
		
		Thread.sleep(2000);
		driver.findElement(By.id("proceedButtonAirport")).click();
		
		Thread.sleep(3000);
		driver.quit();
		 

	} 

}