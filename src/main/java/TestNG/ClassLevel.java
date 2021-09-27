package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassLevel {
	
	/*
	 * sendfriendrequest: Failed
	 * 
	 * receive friend request: Blocked
	 */

	@BeforeClass
	public void browserSetup() {
		System.out.println("Browser");
	}
	
	
	@Test(priority = 4)
	public void tc1() {
		System.out.println("TC1");
	}
	
	@Test(priority = 2)
	public void tc2() {
		System.out.println("TC2");
	}
	
	@Test(priority = 1)
	public void tc3() {
		System.out.println("TC3");
	}
	
	@Test(priority = 3)
	public void tc4() {
		System.out.println("TC4");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Closing Browser");
	}
}