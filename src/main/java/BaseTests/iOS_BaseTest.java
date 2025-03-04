package BaseTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOS_BaseTest{
	

	//<<<<------------------------------------------------------------------------------------------------------>>>
	public static IOSDriver driver;
	public static AppiumDriverLocalService Service;
	
	@Test
	public static void InstallApplication() throws MalformedURLException, URISyntaxException, InterruptedException {
				
		System.out.println("Trying to create Service");
		//MAC
			Service= new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		//Windows
			//Service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Saikiran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
			System.out.println("Service Created");
			//Service.start();
			//Thread.sleep(5000);
			//Assert.assertEquals(Service.isRunning(),true);
			
		
		//iOS
			XCUITestOptions options = new XCUITestOptions();
		
		//Android
			//UiAutomator2Options options= new UiAutomator2Options();
		
		//--------iOS-------------//
			options.setApp("//Users//saikiran_rao//Documents//iOSApps//UIKitCatalog.app"); //UI Catalog .app
			//options.setApp("//Users//saikiran_rao//Documents//iOSApps//Streams.app");
			//options.setApp("//Users//saikiran_rao//git//AppiumPractice//src//test//java//resourses//TestApp 3.app");
			options.setDeviceName("iPhone 16 Pro");
			options.setPlatformVersion("18.2");
			options.setWdaLaunchTimeout(Duration.ofSeconds(5000));
			//options.setChromedriverExecutable("D:\\chromedriver-win64\\chromedriver.exe");
			//optins.setAppPackage("com.panterra.mobile.streams");
			//options.setAppActivity("com.panterra.mobile.streams.MainActivity");
			//options.setPermissions(); //this will not work in iOS 
		//--------Android-------------//
			//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\ApiDemos_debug.apk");
			//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\Streams_Android_Production.apk");
			//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\General_Store.apk");
			//options.setChromedriverExecutable("D:\\chromedriver-win64\\chromedriver.exe");
			//optins.setAppPackage("com.panterra.mobile.streams");
			//options.setAppActivity("com.panterra.mobile.streams.MainActivity");
		
		//Set iOS Driver to Install the Application (URL,Capabilities)
		//driver =new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
		driver =new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
		
		//Android
		//AndroidDriver driver =new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
		
		//driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		Map<String, Object> activeAppInfo = (Map<String, Object>) driver.executeScript("mobile: activeAppInfo");
		String appbundleId= activeAppInfo.get("bundleId").toString();
		System.out.println(appbundleId);
		
		//String appPackage = "com.androidsample.generalstore"; //Android General Store AppPackage
		//String appPackage = "com.panterra.mobile.streams"; //Android Streams App AppPackage
		String bundledId = "com.example.apple-samplecode.UICatalog"; //iOS UI Catalog App
		//String bundledId = "com.panterra.mobile.streams"; //iOS Streams App AppPackage
		//String bundledId= "iOS_Practice.iOSAppGestures.iOSSlide"; //iOS Teat3 App for Slide
		//String bundledId="com.apple.mobileslideshow";
		
			if (driver.isAppInstalled(bundledId)) {
			//if (driver.isAppInstalled(appPackage)) {	
				System.out.println("App is installed on the device.");
			}
			else
			{
				System.out.println("App is not installed on the device.");
			}
		}
	
	@Test
	public static void losingmethods() {
		
		driver.quit();
		Service.stop();
	}
}



	

