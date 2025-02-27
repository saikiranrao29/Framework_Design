
package Utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class iOS_GestureActions  extends AppiumUtils{

	public iOS_GestureActions(AppiumDriver driver) {
		super(driver);
	
	}
	@Test
	public  void iOSLongPress(WebElement longPressElement) throws MalformedURLException, URISyntaxException, InterruptedException {
			
		((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", 
			    ImmutableMap.of(
			        "elementId", ((RemoteWebElement) longPressElement).getId(),
			        "duration", 5000  
			    ));
	}
	@Test
 	public  void iOSScroll(WebElement scrollToElement,String ToDirection) throws MalformedURLException, URISyntaxException, InterruptedException {
		
		
		Map<String,Object> scrollparams = new HashMap<>();
		scrollparams.put("element", ((RemoteWebElement)scrollToElement).getId());
		scrollparams.put("direction",ToDirection);
		
		driver.executeScript("mobile: scroll", scrollparams);
				
	}
	
	@Test
	public void iOSPicker() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("40");
		
		Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Red color component value")).getText(), "40");
	}
	
	@Test
	public void iOSSlide(WebElement sliderIcon,String Percentage) throws MalformedURLException, URISyntaxException, InterruptedException {
	
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
		//sliderIcon.sendKeys("0.80%");
		sliderIcon.sendKeys(Percentage);
	}
	
	
	@Test
	public void iOSSwipe(WebElement swipeToElement,String swipeDirection) throws MalformedURLException, URISyntaxException, InterruptedException {
		
		Map<String,Object> swipeparams = new HashMap<>();
		swipeparams.put("element", ((RemoteWebElement)swipeToElement).getId());
		swipeparams.put("direction",swipeDirection);
		
		driver.executeScript("mobile: swipe", swipeparams);
		
	}
}
