package BaseTests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import Utils.Android_GestureActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Android_BaseTest {

	public static AndroidDriver driver;
	
public void InstallApplication() throws MalformedURLException, URISyntaxException {


		//Start the Appium Service (APIPOB)
		//AppiumDriverLocalService Service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Saikiran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4732).build();
	//	Service.isRunning();
		//Service.start();
		//Assert.assertEquals(Service.isRunning(),true);
								
		UiAutomator2Options options= new UiAutomator2Options();
		//options.setDeviceName("Pixel7Pro");
		options.setAvd("Pixel9Pro");
		options.setAvdLaunchTimeout(Duration.ofSeconds(120));

		options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/General_Store.apk");
		//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\Streams_Android_Production.apk");
		//options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/Streams_Android_Production.apk");
		//options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/ApiDemos_debug.apk");
		
		options.setChromedriverExecutable("D:\\chromedriver-win64\\chromedriver.exe");
		//options.setAppPackage("com.panterra.mobile.streams");
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

	


}
