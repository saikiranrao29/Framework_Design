package OR_iOS_ObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.iOS_GestureActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OR_iOS_Streams extends iOS_GestureActions{
	
public IOSDriver driver;
public OR_iOS_Streams(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@iOSXCUITFindBy(id="sai/test")
		private WebElement username;
	
	@iOSXCUITFindBy(id="sai/test")
		private WebElement password;
	
	public void EnterUserName() {
		username.sendKeys("saikiranone@gmail.com");
	}
	public void PassWord() {
		username.sendKeys("abc@1234");
	}
	
}



