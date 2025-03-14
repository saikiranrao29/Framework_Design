package UDC_Android_UserDefinedClasses;

import PO_Android_PageObjects.PO_Streams_Android;
import io.appium.java_client.android.AndroidDriver;

public class UDC_Streams_Login extends PO_Streams_Android{

	public UDC_Streams_Login(AndroidDriver driver) {
		super(driver);
	}
	
	public void login(String username,String password) {
		
		tapOnWelcomeGotIt();
		enterUserName(username);
		enterPassWord(password);
		TapOnSignIn();
		//okbutton(); //for invalid credentials
	}
	
	public void logout() {
		 tapontheMoreOption();
		 tapontheSettingsOption();
		 tapontheSignoutOption();
		 tapontheSignoutConfirm();
		 	 
	}
}
