package API_Demos_App; 


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageFactoryElements.FormPage;

public class eCommerse_tc_3 extends baseTest{
	@Test
	public static void productPrice() throws InterruptedException {
		
		FormPage loginscreen=new FormPage();
		loginscreen.CountryDropDown(driver);

		String stext="Argentina";
		scrolltotext(stext);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sai Kiran Rao");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).isDisplayed();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		String Price1 =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		String Price2 =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Assert.assertEquals(Price1, driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText());
		Assert.assertEquals(Price2, driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText());
		
		int productSize = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		System.out.println(productSize);
		
		Double FinalAmount = 0.00;
		
		for (int i=0 ;i<productSize ;i++)
		{
			String ProductPrice= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			String Price= ProductPrice.substring(1);
			
			Double Cost= Double.parseDouble(Price);
			FinalAmount = FinalAmount + Cost;		
		}
		
		
		String Cart= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1).trim();
		Double FinalCart= Double.parseDouble(Cart);
		Assert.assertEquals(FinalCart, FinalAmount);
		
		WebElement element =driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longpressaction(element);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).isDisplayed();
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		System.out.println(driver.getContextHandles());
		//To switch from AppView to WebView
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.androidsample.generalstore:id/webView"))));
		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//To switch from WebView to AppView
		driver.context("NATIVE_APP");
		driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).isDisplayed();
		

		
	}
}
