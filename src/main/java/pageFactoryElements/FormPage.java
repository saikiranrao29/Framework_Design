package pageFactoryElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage {

	
	public FormPage() {
		
		//PageFactory.initElements(driver,this);
		
	}
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	private WebElement ClickonCountry;
	
	public void CountryDropDown(AndroidDriver driver) {
		ClickonCountry.click();
	}
	
	
}
