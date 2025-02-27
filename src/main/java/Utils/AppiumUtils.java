package Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	AppiumDriver driver;

	public AppiumUtils(AppiumDriver driver){
		
		this.driver=driver;
	}


	public static List<HashMap<String, String>> jasonDataExtraction() throws IOException {
	
        // Read the file content as a string
        String jsonContent = FileUtils.readFileToString(new File("//Users//saikiran_rao//git//Appium_Framework//src//main//java//TestData//login.json"), "UTF-8");
       
        // JSON String to MAP- by Jackson data bind
        ObjectMapper mapper=new ObjectMapper(); 
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
        		new TypeReference<List<HashMap<String,String>>>(){});
        
        return data;
	}

}