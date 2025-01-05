package API_Demos_App;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class baseTest {
	
	public static AndroidDriver driver;
	
public static void InstallApplication() throws MalformedURLException, URISyntaxException {
		
		//Start the Appium Service (APIPOB)
		AppiumDriverLocalService Service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Saikiran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4732).build();
		Service.isRunning();
		//Service.start();
		//Assert.assertEquals(Service.isRunning(),true);
								
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("Pixel7Pro");
		options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\ApiDemos_debug.apk");
		//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\Streams_Android_Production.apk");
		//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\General_Store.apk");
		options.setChromedriverExecutable("D:\\chromedriver-win64\\chromedriver.exe");
		//optins.setAppPackage("com.panterra.mobile.streams");
		//options.setAppActivity("com.panterra.mobile.streams.MainActivity");
		
		//Set Android Driver to Install the Application (URL,Capabilities)
		driver =new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//String appPackage = "com.androidsample.generalstore"; //General Store AppPackage
		//String appPackage = "com.panterra.mobile.streams"; //Streams App AppPackage
		//String appPackage = ""
		
//		//Checking is App Installed or not
//		if (driver.isAppInstalled(appPackage)) {
//		    System.out.println("App is installed on the device.");
//		} else {
//		    System.out.println("App is not installed on the device.");
//		}
	}

	
//<<<<------------------------------------------------------------------------------------------------------>>>
	public static void longpressaction(WebElement longpress) {
		
		driver.executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) longpress).getId(),"Duration" ,2000));
	}
	
//<<<<------------------------------------------------------------------------------------------------------>>>
	public static void scrolltotext(String stext) {
		
		//I)By androidUIAutomator //Will Use When Where you know the exact location to scroll
		
		// ===> For Direct Text 
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		//Getting Text from Actual  Arguments 
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+stext+"\"));"));
	}
	
//<<<<------------------------------------------------------------------------------------------------------>>>
	public static void scrolluntilelement(WebElement element) throws InterruptedException {
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
//<<<<------------------------------------------------------------------------------------------------------>>>		
	public static void swipeleft(String swipeDirection,WebElement firstImage){
		// Swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) firstImage).getId(),
		    "direction", swipeDirection,
		    "percent", 0.1
		));
	}
//<<<<------------------------------------------------------------------------------------------------------>>>	
	public static void DragDrop(WebElement dragElement,int dropX,int dropY) {
		
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) dragElement).getId(),
				"endX", dropX,
			    "endY", dropY));
	}

}
