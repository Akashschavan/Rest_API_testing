package basepackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {

	public static String baseurl = "https://reqres.in/" ;
	public static RequestSpecification spec = RestAssured.given();
	public static Response response ;
	
	
	
}
