package OR_Android_ObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Android_GestureActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OR_Streams extends Android_GestureActions{
	public AndroidDriver driver;
	
	public OR_Streams(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.panterra.mobile.streams:id/btn_next") protected WebElement welcomeGotIt;
	@AndroidFindBy(id="com.panterra.mobile.streams:id/username") protected WebElement userNameFeild;
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.panterra.mobile.streams:id/password']") protected WebElement passwordFeild;
	@AndroidFindBy(id="com.panterra.mobile.streams:id/login") protected WebElement signInButton;
	@AndroidFindBy(id="com.panterra.mobile.streams:id/copyrights") protected WebElement privacypolicayhyperlink;
	@AndroidFindBy(id="android:id/button1") protected WebElement invalidokbutton;
	@AndroidFindBy(accessibility="More options") protected WebElement MoreOptions;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Settings\")") protected WebElement settings;
	@AndroidFindBy(id="com.panterra.mobile.streams:id/signout") protected WebElement singout;
	@AndroidFindBy(id="android:id/button1") protected WebElement SignoutConfirm;
	
	}

