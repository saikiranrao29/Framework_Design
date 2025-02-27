package PO_Android_PageObjects;

import OR_Android_ObjectsRepository.OR_Streams;
import io.appium.java_client.android.AndroidDriver;

public class PO_Streams_Android extends OR_Streams{
	
	public AndroidDriver driver;
	
	public PO_Streams_Android(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void tapOnWelcomeGotIt() {
		welcomeGotIt.click();
	}
	

	public void enterUserName(String username) {
		userNameFeild.sendKeys(username);
	}
	
	
	public void enterPassWord(String password) {
		passwordFeild.sendKeys(password);
	}
	
	
	public void TapOnSignIn(){
		signInButton.click();
	}
	
	
	public void tapontheprivacypolicay() {
		privacypolicayhyperlink.click();
	}
	
	
	
	}

