package PO_Android_PageObjects;

import java.util.NoSuchElementException;

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
	
	public void okbutton() {
		invalidokbutton.click();
	}
	
	public void tapontheprivacypolicay() {
		privacypolicayhyperlink.click();
	}
	
	public void tapontheMoreOption() {
		MoreOptions.click();
	}
	
	public void tapontheSettingsOption() {
		settings.click();	
	}
	public void tapontheSignoutOption() {
		scrolltotext("Sign Out");
		singout.click();
	}
	
	public void tapontheSignoutConfirm() {
		SignoutConfirm.click();
	}
	
	}

