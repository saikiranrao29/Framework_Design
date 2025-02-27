package OR_Android_ObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OR_API_Demos extends Utils.Android_GestureActions{

	public AndroidDriver driver;

	public OR_API_Demos(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);	
	}

	@AndroidFindBy(id = "android:id/text1")
		protected WebElement countryName;
	@AndroidFindBy(id= "com.androidsample.generalstore:id/btnLetsShop")
		protected WebElement letsShop;
	@AndroidFindBy(xpath= "//android.widget.Toast[1]")
		protected WebElement alert;
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
		protected WebElement Namefield;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
		protected WebElement femaleGender;
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
		protected WebElement maleGender;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		protected WebElement shop;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
		protected WebElement productsScreen;
}
