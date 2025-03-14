package Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {

//-----------Jason File Data Method-----------
	public List<HashMap<String, String>> jasonDataExtraction(String testDataPath) throws IOException {
	
        // Read the file content as a string
        String jsonContent = FileUtils.readFileToString(new File(testDataPath), "UTF-8");
       
        // JSON String to MAP- by Jackson data bind
        ObjectMapper mapper=new ObjectMapper(); 
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
        		new TypeReference<List<HashMap<String,String>>>(){});
        System.out.println(data);
        return data;
	}
	
	
//-----------To start the Appium Server-----------
	public AppiumDriverLocalService startAppiumService(String IPAdress, int Port){
		AppiumDriverLocalService Service= new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress(IPAdress).usingPort(Port).build();
		//AppiumDriverLocalService Service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Saikiran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(IPAdress).usingPort(Port).build();		
		return Service;
		//127.0.0.1
		//4732
	
	}
}