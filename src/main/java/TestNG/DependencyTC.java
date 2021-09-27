package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTC {

	@Test
	public void login() {
		System.out.println("Login TC");
		Assert.assertTrue(true);
	}
	@Test(dependsOnMethods = "login")
	public void sendFriendRequest() {
		System.out.println("sendFriendRequest");
	}
	@Test(dependsOnMethods = "login")
	public void receiveFriendRequest() {
		System.out.println("receiveFriendRequest");
	}
}