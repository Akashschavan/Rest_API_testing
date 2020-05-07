package utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extentmanager {
	
	
	public static ExtentReports extent ;
	
	public static ExtentReports createInsantce () {
		
		
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
		 
		 return extent ; 
	}

}
