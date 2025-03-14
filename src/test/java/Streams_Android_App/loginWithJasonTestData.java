package Streams_Android_App;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.Android_BaseTest;
import UDC_Android_UserDefinedClasses.UDC_Streams_Login;
import Utils.AppiumUtils;

public class loginWithJasonTestData extends Android_BaseTest{
	
	@Test (dataProvider = "getTestDataByJason")
	public void FillForm(HashMap<String,String> input) throws URISyntaxException, InterruptedException, IOException {
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
	
	@DataProvider
	public Object[][] getTestDataByJason() throws IOException{
		{
			String testDataPath="/Users/saikiran_rao/git/Appium_Framework/src/main/java/TestData/login.json";
			
			AppiumUtils AppiumUtils= new AppiumUtils();
			
			List<HashMap<String,String>> data=AppiumUtils.jasonDataExtraction(testDataPath);	
			
			
			  Object[][] testData = new Object[data.size()][1]; // Create a 2D array dynamically
			    
			    for (int i = 0; i < data.size(); i++) {
			        testData[i][0] = data.get(i); // Assign each HashMap to the array
			    }

			    return testData;
				
			}
		}
	}
		
		
		
//		int datasize = data.size();		
//		Object[][] obj = new Object [datasize][1];		
//		for(int i=0; i<datasize; i++) {			
//		    obj[i][0] = data.get(i);		
//		}		
//		return obj;


