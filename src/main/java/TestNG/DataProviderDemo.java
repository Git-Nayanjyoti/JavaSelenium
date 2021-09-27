package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	/*
	 * Data Provider
	 * we might have to test the same test case
	 * with different value set
	 */
	
	@Test(dataProvider = "getData")
	public void login(Object username, Object password) {
		System.out.println("Login case");
		System.out.println(username + "  " + password);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//first parameter is row
		//row indicates how many times you want to executed
		
		//second parameter is column
		//it indicates how many parameters to be passed per test
		Object[][] data = new Object[4][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
		
		data[1][0] = "user2";
		data[1][1] = "pass2";
		
		data[2][0] = "user3";
		data[2][1] = "pass3";
		
		data[3][0] = "user4";
		data[3][1] = "pass4";
		return data;
	}
}