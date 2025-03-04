package Streams_Android_App;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTests.Android_BaseTest;
import UDC_Android_UserDefinedClasses.UDC_Streams_Login;
import Utils.AppiumUtils;

public class loginWithJasonTestData extends Android_BaseTest{

	 
	@Test (dataProvider = "getData")
	public void FillForm(HashMap<String,String> input) throws MalformedURLException, URISyntaxException, InterruptedException {
		
		InstallApplication();
		UDC_Streams_Login UDC= new UDC_Streams_Login(driver);
		UDC.login(input.get("username"),input.get("password"));
		Thread.sleep(5000);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		{
			String testDataPath="/Users/saikiran_rao/git/Appium_Framework/src/main/java/TestData/login.json";
			
			AppiumUtils AppiumUtils= new AppiumUtils();
			
			List<HashMap<String,String>> data=AppiumUtils.jasonDataExtraction(testDataPath);			
			return new Object[] [] {
				{data.get(0)},{data.get(1)},{data.get(2)}
				
									};
		}
		
		
		
	}	
		
		
}	
		
		
		
//		int datasize = data.size();		
//		Object[][] obj = new Object [datasize][1];		
//		for(int i=0; i<datasize; i++) {			
//		    obj[i][0] = data.get(i);		
//		}		
//		return obj;


