package Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppiumUtils {

//Jason File Data Method
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

}