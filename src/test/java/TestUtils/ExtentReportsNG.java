package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	public static ExtentReports extent;
		
	public static ExtentReports getReportsObject() {
		
		//creating extentsparkreporter Class
		
		//String reportsPath = "/Users/saikiran_rao/git/Appium_Framework/Reports";
		String reportsPath = System.getProperty("user.dir")+"/Reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportsPath);
		reporter.config().setReportName("script-results");
		reporter.config().setDocumentTitle("Streams");
		
		 //Create extentreports Classe & Attach the Above Reporter
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TesterName", "Sai Kiran Rao : Mobile Automation Test Engineer");
		return extent;
		
	}

}
