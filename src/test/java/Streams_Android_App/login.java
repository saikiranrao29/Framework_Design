package Streams_Android_App;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UDC_Android_UserDefinedClasses.UDC_Streams_Login;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class login extends BaseTests.Android_BaseTest{
	
	//login with data provider annotation from the same class
	
@Test(dataProvider = "logincredentials")
	public void logIntoStreams(String username, String password) throws MalformedURLException, URISyntaxException {
		
		InstallApplication();
		UDC_Streams_Login loginPage=new UDC_Streams_Login(driver);
		loginPage.login(username, password);
	}

	@DataProvider
	public Object[][] logincredentials() {
		
		return new Object[] [] {
			{"saikiranone@dcwvalidation","abc@1234"}
								};
	}
}
