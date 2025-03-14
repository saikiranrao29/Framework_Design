package Streams_Android_App;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.Android_BaseTest;
import UDC_Android_UserDefinedClasses.UDC_Streams_Login;

public class multipleLogin extends Android_BaseTest{
	
	//login with multiple test data by dataprovider in the same class
	
	@Test (dataProvider = "getData")
	public void FillForm(String username,String password) throws URISyntaxException, InterruptedException, IOException {
		
		InstallApplication();
		UDC_Streams_Login UDC= new UDC_Streams_Login(driver);
		UDC.login(username,password);
		Thread.sleep(5000);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		{
			return new Object[] [] {
					{"saikiranone@dcwvalidation","xyz@1234"},
					{"saikirantwo@dcwvalidation","xyz@1234"},
					{"saikiranthree@dcwvalidation","xyz@1234"},
					{"saikiranfour@dcwvalidation","xyz@1234"}
									};
		}
	}
}

