package Basic;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class SearchBusFromHome {
	static WebDriver driver;
 
	public static void datepicker(String date) throws InterruptedException, ParseException {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1];
		Date currentDate = new Date();
		String formateDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formateDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formateDate);
		if (inputDate.before(currentDate)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			Thread.sleep(3000);
			while (!driver.findElement(By.className("monthTitle")).getText().equalsIgnoreCase(MonthYear)) {
				driver.findElement(By.className("next")).click();
			}

			List<WebElement> size = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[3]"))
					.findElements(By.tagName("td"));
			for (int i = 3; i <= size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver
							.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[" + i + "]/td[" + j + "]"));

					if (MonthYear == "Feb 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						System.out.println(findDate.getText());
						findDate.click();
						i = 0;
						break;
					}

				}
				if (i == 0) {
					break;
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException, ParseException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://redbus.in");
		driver.manage().window().maximize();

		// enter from
		driver.findElement(By.id("src")).sendKeys("Guwahati (All Locations)");
		Thread.sleep(2000);
		List<WebElement> searchOptionsFrom = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < args.length; i++) {
			if (searchOptionsFrom.get(i).getText().equals("Guwahati (All Locations)")) {
				searchOptionsFrom.get(i).click();
			}
		}

		// enter to

		driver.findElement(By.id("dest")).sendKeys("Jorhat");
		Thread.sleep(2000);
		List<WebElement> searchOptionsTo = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < args.length; i++) {
			if (searchOptionsTo.get(i).getText().equals("Jorhat")) {
				searchOptionsTo.get(i).click();
			}
		}

		Thread.sleep(2000);
		driver.findElement(By.id("onward_cal")).click();
		datepicker("25-Oct-2021");

		Thread.sleep(1000);
		driver.findElement(By.id("search_btn")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[3]/div[1]/i")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[3]/div[2]/i")).click();

	} 

}
