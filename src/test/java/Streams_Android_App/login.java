package Streams_Android_App;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UDC_Android_UserDefinedClasses.UDC_Streams_Login;

import java.io.IOException;
import java.net.URISyntaxException;

public class login extends TestUtils.Android_BaseTest{
	UDC_Streams_Login loginPage;
	//login with data provider annotation from the same class
	
@Test(dataProvider = "logincredentials")
	public void logIntoStreams(String username, String password) throws URISyntaxException, IOException {
		
		InstallApplication();
		loginPage=new UDC_Streams_Login(driver);
		loginPage.login(username, password);
	}

	@DataProvider
	public Object[][] logincredentials() {
		
		return new Object[] [] {
			{"saikiransix@dcwvalidation","sai@1234"}
								};
	}
	@Test 
	public void logoutfromApp() {
		loginPage.logout();
	}
}
