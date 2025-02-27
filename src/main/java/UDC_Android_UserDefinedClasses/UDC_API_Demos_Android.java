package UDC_Android_UserDefinedClasses;

import PO_Android_PageObjects.PO_API_Demos_Android;
import io.appium.java_client.android.AndroidDriver;

public class UDC_API_Demos_Android extends PO_API_Demos_Android{


	public UDC_API_Demos_Android(AndroidDriver driver) {
		super(driver);
	}
	
	public void AlertValidation(String stext) {
		selectCountry(stext);
		shop();
		alertText();		
	}
	
	public void GoToProducts(String Name,String typeOfGender) {

		entreName(Name);
		setGender(typeOfGender);
		letsGoForShop();
		isProductsDisplayed();
	}
}
