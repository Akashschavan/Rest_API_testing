package utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner extends TestListenerAdapter {
	
	
	public ExtentHtmlReporter Htmlreporter ;
	public ExtentReports extent ;
	public ExtentTest Test ;

	public void onStart (ITestContext testcontext) {
		String directory = System.getProperty("user.dir") + "/Report" ;
		new File (directory).mkdirs () ;
		String path = directory + "/apireport" ;
		ExtentHtmlReporter Htmlreporter =  new ExtentHtmlReporter (path) ;
		Htmlreporter = new ExtentHtmlReporter ("C:\\Users\\dell\\eclipse-workspace\\employee\\Report\\myreport.html") ;
		 Htmlreporter.config().setDocumentTitle("API Test Report");
		 Htmlreporter.config().setReportName("Rest assured test");
		//Htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 Htmlreporter.config().setTheme(Theme.STANDARD);
		
		 extent = new ExtentReports () ;
		 extent.setSystemInfo("Host Name", "localhost");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("User Name", "Akash");
		 extent.attachReporter(Htmlreporter);
	
	/*Htmlreporter = new ExtentHtmlReporter ("C:\\Users\\dell\\eclipse-workspace\\employee\\Report\\myreport.html") ;
	extent.attachReporter(Htmlreporter);
	 extent.setSystemInfo("Host Name", "localhost");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("User Name", "Akash");
	extent = new ExtentReports () ;
	 Htmlreporter.config().setDocumentTitle("API Test Report");
	 Htmlreporter.config().setReportName("Rest assured test");
	//Htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 Htmlreporter.config().setTheme(Theme.STANDARD);
	 Htmlreporter.loadXMLConfig(new File ("C:\\Users\\dell\\eclipse-workspace\\employee\\extent-config.xml")); */
	}

	public void onTestSuccess (ITestResult result) {
	
 
		Test = extent.createTest(result.getName()) ;
 
		Test.log(Status.PASS, "test case pass is"+ result.getName()) ;
	
}

	public void onTestFailure (ITestResult result) {
	
	 Test = extent.createTest(result.getName()) ;
	 Test.log(Status.FAIL, "test case fail is"+ result.getName()) ;
	// Test.log(Status.FAIL, "test case fail is"+ result.getThrowable()) ;
		}

	public void onTestSkipped (ITestResult result) {
	
	 Test = extent.createTest(result.getName()) ;
	 Test.log(Status.SKIP, "test case skiped is"+ result.getName()) ;
		
	}

	public void onTestfinish (ITestContext testcontext) {
	extent.flush();
	 }

}
