package PO_Android_PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;

import OR_Android_ObjectsRepository.OR_API_Demos;
import io.appium.java_client.android.AndroidDriver;

public class PO_API_Demos_Android extends OR_API_Demos{


	public PO_API_Demos_Android(AndroidDriver driver) {
		super(driver);
	}


	public void selectCountry(String stext) {

		countryName.click();
		scrolltotext(stext);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + stext + "']")).click();
	}


	public void shop() {
		letsShop.click();
	}

	public void alertText()
	{
		String toastmessage= alert.getDomAttribute("name");
		Assert.assertEquals(toastmessage,"Please enter your name");
	}


	public void entreName(String Name) {
		Namefield.sendKeys(Name);
	}


	public void setGender(String typeOfGender) {
		if(typeOfGender.contains("Female")) {
			femaleGender.click();			
		}
		else {
		}
		maleGender.click();
	}


	public void letsGoForShop() {
		shop.click();
	}


	public void isProductsDisplayed() {
		boolean productsStatus= productsScreen.isDisplayed();
		assertTrue(productsStatus);
	}		

}
