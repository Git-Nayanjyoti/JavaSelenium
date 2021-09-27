package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo {

	/*
	 * Annotations/Tags:
	 * BeforeSuite: seting some system property
	 * BeforeTest: Report setup
	 * BeforeClass: Login Actions
	 * BeforeMethod: URL is entered and app is ready
	 * Test: actual TC
	 * AfterMethod: sing out
	 * AfterClass: close browser, delete all cookies
	 * AfterTest: Complete Report Capture
	 * AfterSuite: tearDown, 
	 * 
	 * TC are always identified by @Test
	 * 
	 * execution is based alphabetically
	 */
	@Test (groups = "android")
	public void xeroxMachineTest() {
		System.out.println("TC4: xerox machine test");
	}
	
	@Test (groups = "regression")
	public void homepageTest() {
		System.out.println("TC3: Validating Home Page Test");
		Assert.fail();
	}
	
	@Test(groups = "smoke")
	public void validateTitle() {
		System.out.println("TC1: Validating Title");
	}
	
	@Test(groups = "smoke")
	public void validateLogin() {
		System.out.println("TC2: Validating Login Feature");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method: Setting up browser and loading appplication");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method: CLosing the browser");
	}
	
	/*
	 * bm
	 * vl
	 * vt
	 * am
	 * 
	 * bm
	 * vl
	 * am
	 * 
	 * bm
	 * vt
	 * am
	 * 
	 * bm
	 * tc3
	 * am
	 * 
	 */
	
}