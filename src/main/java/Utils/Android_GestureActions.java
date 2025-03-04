package Utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Android_GestureActions extends AppiumUtils{
	
		AndroidDriver driver;
	
		public Android_GestureActions(AndroidDriver driver) {
		this.driver=driver;
			}
		//<<<<--------------------------Long Press----------------------------------------------------------------->>>
		@Test
		public  void longpressaction(WebElement longpress) {
			
			driver.executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId", ((RemoteWebElement) longpress).getId(),"Duration" ,2000));
		}
		
	//<<<<--------------------------Scroll to Text------------------------------------------------------------->>>
		@Test
		public  void scrolltotext(String stext) {
			
			//I)By androidUIAutomator //Will Use When Where you know the exact location to scroll
			
			// ===> For Direct Text 
			//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
			//Getting Text from Actual  Arguments 
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+stext+"\"));"));
		}

	//<<<<--------------------------Scroll to Element------------------------------------------------------------->>>		
		@Test
		public void scrolluntilelement(WebElement element) throws InterruptedException {
			//II)By JavaScript Executor //Will Use only till your element found/till your co-ordinates //will use when that element is still exists or not 
			// need to keep on check if that element is exists or not 
					
			boolean canScrollMore;
			{	
				do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 500, "top", 500, "width", 600, "height", 800,
			    "direction", "down",
			    "percent", 10.0
			));

			try {
				Thread.sleep(2000);
	            element.click();
	            System.out.println("Clicked on 'Vertices' element!");
	            break;  // Exit the loop after clicking the element
	        	}
			catch (NoSuchElementException e){
	        // If the element is not found, we just continue to the next scroll
	        System.out.println("Element with text 'Vertices' not found, continuing to scroll...");
											}
				}
			while (canScrollMore == true);
			}	
		}
//<<<<--------------------------Swipe Action------------------------------------------------------------->>>	
		@Test
		public void swipeleft(String swipeDirection,WebElement firstImage){
			// Swipe
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) firstImage).getId(),
			    "direction", swipeDirection,
			    "percent", 0.1
			));
		}
		
//<<<<---------------------------Drag Drop--------------------------------------------------------------->>>	
		
		public void DragDrop(WebElement dragElement,int dropX,int dropY) {
			
			driver.executeScript("mobile: dragGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement) dragElement).getId(),
					"endX", dropX,
				    "endY", dropY));
		}

	}
