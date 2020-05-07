package utility;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

;

public class Extendreport extends TestListenerAdapter {
	
	
	ExtentReports extent ;
	ExtentTest logger ;
	
	@BeforeTest
	 public void startreport () {
		   
		 extent = new ExtentReports ("C:\\Users\\dell\\eclipse-workspace\\employee\\test-output\\myreport.html" , true) ;
		 extent.addSystemInfo("envirment", "QA") ;
		 extent.addSystemInfo("username", "Aksh") ;
		 extent.addSystemInfo("Hostname", "local") ;
		 extent.loadConfig(new File ("C:\\Users\\dell\\eclipse-workspace\\employee\\extent-config.xml"));
	 }
	@Test
	 public void passTest(){
		 //extent.startTest("TestCaseName", "Description")
		 //TestCaseName � Name of the test
		 //Description � Description of the test
		 //Starting test
	
		logger = extent.startTest("passTest");
		 Assert.assertTrue(true);
		 //To generate the log when the test case is passed
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		 
		 
		 }
		 
		 @Test
		 public void failTest(){
		 logger = extent.startTest("failTest");
		 Assert.assertTrue(false);
		 logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		 }
		 @AfterMethod
		 public void getResult(ITestResult result){
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 }else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 // ending test
		 //endTest(logger) : It ends the current test and prepares to create HTML report
		 extent.endTest(logger);
		 }
		 @AfterTest
		 public void endReport(){
		 // writing everything to document
		 //flush() - to write or update test information to your report. 
		                extent.flush();
		                //Call close() at the very end of your session to clear all resources. 
		                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		                //Once this method is called, calling any Extent method will throw an error.
		                //close() - To close all the operation
		                extent.close();
		    }
	 
}
