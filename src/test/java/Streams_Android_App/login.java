package Streams_Android_App;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UDC_Android_UserDefinedClasses.UDC_Streams_Login;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class login extends BaseTests.Android_BaseTest{
	
@Test(dataProvider = "logincredentials")
	public void logIntoStreams(String userName, String password) throws MalformedURLException, URISyntaxException {
		
		InstallApplication();
		UDC_Streams_Login loginPage=new UDC_Streams_Login(driver);
		loginPage.tapOnWelcomeGotIt();
		loginPage.enterUserName(userName);
		loginPage.enterPassWord(password);
		loginPage.TapOnSignIn();
		
	}

	@DataProvider
	public Object[][] logincredentials() {
		
		return new Object[] [] {
			{"saikiranone@dcwvalidation","abc@1234"}
								};
	}
}
