package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Onlylistner implements ITestListener {
	private static ExtentReports extent = Extentmanager.createInsantce() ;
	private static ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>() ;
	

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName()) ;
	extentTest.set(test);	
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "testmethod " + result.getMethod().getMethodName() + "successfull" ;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN) ;
		extentTest.get().log(Status.PASS, m) ;
		
	}

	public void onTestFailure(ITestResult result) {
		String logText = "testmethod " + result.getMethod().getMethodName() + "unsuccessfull" ;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED) ;
		extentTest.get().log(Status.FAIL, m) ;
		
	}

	public void onTestSkipped(ITestResult result) {
		String logText = "testmethod " + result.getMethod().getMethodName() + "skipped" ;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW) ;
		extentTest.get().log(Status.SKIP, m) ;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
		
	}
	
	
	

}
