package TestReport;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import TestUtils.Android_BaseTest;
import TestUtils.ExtentReportsNG;
import UDC_Android_UserDefinedClasses.UDC_Streams_Login;

public class loginReport extends Android_BaseTest{
	UDC_Streams_Login loginPage;
	
	@Test(dataProvider="loginDetails")
	public void login(HashMap<String, String> input) throws URISyntaxException, IOException {
	
		ExtentReports extent =ExtentReportsNG.getReportsObject();
		
		extent.createTest("logintest");
		InstallApplication();
		loginPage=new UDC_Streams_Login(driver);
		loginPage.login(input.get("username"), input.get("password"));
		extent.flush();
	}
	
	@DataProvider
	public Object[][] loginDetails() throws IOException{
		
		String testDataPath="/Users/saikiran_rao/git/Appium_Framework/src/main/java/TestData/single_loginDate.json";	
	    List<HashMap<String, String>> data =jasonDataExtraction(testDataPath);
	    return new Object[][] { { data.get(0) } };
	}
	
	@Test
	public void logout() {
		loginPage.logout();	
	}

}
