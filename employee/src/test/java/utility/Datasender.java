package utility;

import org.testng.annotations.DataProvider;

public class Datasender {
	
	@DataProvider 
	public static Object[][] empDataforpost () {
		Object[][] data = new Object [1][2] ;
		data[0][0] = "abc" ;
		data[0][1] = "xyz" ;
		return data ;
		
	}
	@DataProvider 
	public static Object[][] empDataforput () {
		Object[][] data = new Object [1][1] ;
		data[0][0] = "abc" ;
		return data ;
		
	}
	
	
	
}


