package TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Android_BaseTest extends AppiumUtils{

	public static AndroidDriver driver;
	public AppiumDriverLocalService Service;
	
public void InstallApplication() throws URISyntaxException, IOException {

	
	Properties Properties=new Properties();
	FileInputStream file= new FileInputStream("/Users/saikiran_rao/git/Appium_Framework/config.properties");
	Properties.load(file);
	String IPAdress= Properties.getProperty("IPAdress");
	String PortValue= Properties.getProperty("Port");
	int Port= Integer.parseInt(PortValue);
	
	Service = startAppiumService(IPAdress,Port);
	//Service.start();
	//Service.stop();
								
		UiAutomator2Options options= new UiAutomator2Options();
		//options.setDeviceName(Properties.getProperty("AndroidDeviceName"));
		options.setAvd(Properties.getProperty("AndroidAVDDeviceName"));
		options.setAvdLaunchTimeout(Duration.ofSeconds(120));

		//options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/General_Store.apk");
		options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/Streams_Android_Production.apk");
		//options.setApp("/Users/saikiran_rao/git/AppiumPractice/src/test/java/resourses/ApiDemos_debug.apk");
		//options.setApp("C:\\Users\\Saikiran\\eclipse-workspace\\Streams\\src\\test\\java\\resourses\\Streams_Android_Production.apk");
		
		options.setChromedriverExecutable("D:\\chromedriver-win64\\chromedriver.exe");
		options.setAppPackage("com.panterra.mobile.streams");
		options.setAppActivity("com.panterra.mobile.streams.MainActivity");
		options.autoGrantPermissions();
		
		//Set Android Driver to Install the Application (URL,Capabilities)
		//driver =new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
		driver =new AndroidDriver(Service.getUrl(),options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
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
