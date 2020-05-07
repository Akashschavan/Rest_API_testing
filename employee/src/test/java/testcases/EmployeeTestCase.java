package testcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.Baseclass;
import io.restassured.http.Header;
import io.restassured.response.ResponseBody;
import utility.Datagenerator;
import utility.Datasender;
public class EmployeeTestCase extends Baseclass{
	Datagenerator generator = new Datagenerator () ;

	@Test
	public void getTestcase_01 () {
		
	response = spec.get(baseurl + "api/users/2");
	String body = response.getBody().jsonPath().getString("data.id") ;
	Assert.assertEquals(body, "2");
	System.out.println(body);
	
	
	//int code = response.getStatusCode() ;
	//Assert.assertEquals(code, 200) ;
		
	}
	@Test 
	public void getTestcase_02 () {
		response = spec.get(baseurl + "api/users/2");
		String contenttype = response.getContentType() ;
		System.out.println(contenttype);
		Assert.assertEquals(contenttype, "application/json; charset=utf-8");
	}
	@Test 
	public void getTestcase_03 () {
	response = spec.get(baseurl + "api/users/2");
	long time =	response.getTime() ;
	System.out.println(time);
	Assert.assertTrue(time<2000);
	}
	@Test 
	public void getTestcase_04 () {
	String incoding = response.getHeader("Content-Encoding") ;
	System.out.println(incoding);
	Assert.assertEquals(incoding.contains("gzip") , true);
	}
	@Test 
	public void getTestcase_05 () {
		
		// Header length = response.headers().get("contentlength") ;
		String length1 = response.header("contentleght") ;
		System.out.println(length1);
		
		
	}
//	@Test (dataProviderClass = Datasender.class , dataProvider = "empDataforpost")
   public void postEmployee_01 (String job , String name ) {
	Map <String , String > dataforpost = generator.createpayloadforpost(job, name);
	System.out.println(dataforpost);
	response = given().body(dataforpost).post(baseurl + "/api/users") ;
	//response = spec.body(dataforpost).post(baseurl + "/api/users");
	System.out.println(response);
	int code = response.getStatusCode() ;
	Assert.assertEquals(code, 200) ;	
	}
	
//	@Test 
	public void postEmployee_02 () {
		String body = response.getBody().asString() ;
		Assert.assertEquals(body.contains("xyz") , true);
		
		
	}
	
//	@Test (dataProviderClass = Datasender.class , dataProvider = "empDataforput" )
	public void updateemployee (String job) {
		Map <String , String > dataforput = generator.createpayloadforput(job) ;
		response = spec.body(dataforput).put(baseurl + "/api/users") ;
		int code = response.getStatusCode() ;
		Assert.assertEquals(code, 200) ;	
		
		
	}
	@Test 
	public void getlistofemployee () {
		
       spec.param("page", "2").get(baseurl + "api/users").then().assertThat().body("data.id", hasItems(7 , 8 ,9, 10 ,11 ,12));
		//int code = response.getStatusCode() ;
		//Assert.assertEquals(code, 200) ;
	//	List <Object > body = response.getBody().jsonPath().getList("data.id") ;
		
	//	Assert.assertEquals(body.contains("7") , true);
	//	System.out.println(body);
		//String responsebody = response.getBody().asString() ;
		//Assert.assertEquals(body, hasItems("7","8", "9" , "10" ,"11", "12"));
		//Assert.assertEquals(body, hasItems(7 , 8, 9, 10, 11, 12 ));
		//List <Integer> expectedlist = new ArrayList<Integer>();
		//   expectedlist.add(7);
		//    expectedlist.add(8);
		 //   expectedlist.add(9);
		 //   expectedlist.add(10);
		  // expectedlist.add(11);
		 //  expectedlist.add(12);
	//	Assert.assertEquals(body, expectedlist);
		
	}
}
