package TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import Utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class iOS_BaseTest extends AppiumUtils{
	

	//<<<<------------------------------------------------------------------------------------------------------>>>
	public  IOSDriver driver;
	public  AppiumDriverLocalService Service;
	
	@Test
	public void InstallApplication() throws URISyntaxException, InterruptedException, IOException {
				
		Properties Properties=new Properties();
		FileInputStream file= new FileInputStream("/Users/saikiran_rao/git/Appium_Framework/src/main/java/resources/config.properties");
		Properties.load(file);
		String IPAdress= Properties.getProperty("IPAdress");
		String PortValue= Properties.getProperty("Port");
		int Port= Integer.parseInt(PortValue);
				
		Service = startAppiumService(IPAdress,Port);
		//Service.start();
		//Service.stop();
			
		
		//iOS
			XCUITestOptions options = new XCUITestOptions();
		
		//Android
			//UiAutomator2Options options= new UiAutomator2Options();
		
		//--------iOS-------------//
			options.setApp("//Users//saikiran_rao//Documents//iOSApps//UIKitCatalog.app"); //UI Catalog .app
			//options.setApp("//Users//saikiran_rao//Documents//iOSApps//Streams.app");
			//options.setApp("//Users//saikiran_rao//git//AppiumPractice//src//test//java//resourses//TestApp 3.app");
			options.setDeviceName(Properties.getProperty("iOSDeviceName"));
			options.setPlatformVersion(Properties.getProperty("iOSVersion"));
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
		//driver =new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
			
			driver =new IOSDriver(Service.getUrl(),options);	
	
			
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
	public void losingmethods() {
		
		driver.quit();
		Service.stop();
	}
}



	

