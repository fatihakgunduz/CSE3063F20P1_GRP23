import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Input {
	
	JSONArray datasets; 
    JSONArray users; 
    Double checkProbability;
    String fileName;
	
    public Input(String fileName) {
		super();
		this.fileName = fileName;
    }
    
    
    public ReadDataset datasetObjectReturner() {
    	JSONParser parser = new JSONParser();
        try {
    	Object cfg = parser.parse(new FileReader(fileName)); 
        JSONObject jsonObject = (JSONObject)cfg;
    	datasets = (JSONArray)jsonObject.get("Datasets");
    	} catch(Exception e) {
        	e.printStackTrace();
        }  
        ReadDataset readDataset = new ReadDataset(datasets);
    	return readDataset;    
    	
    }
    
    public ReadUser userObjectReturner() {
    	JSONParser parser = new JSONParser();
        try {
    	Object cfg = parser.parse(new FileReader(fileName));
        
        JSONObject jsonObject = (JSONObject)cfg;
    	users = (JSONArray)jsonObject.get("Users");
    	} catch(Exception e) {
        	e.printStackTrace();
        }
    	ReadUser readUser = new ReadUser(users);
    	return readUser;
    }
    

    
    public ArrayList userReturner(ReadUser readUser) {
    	return readUser.createUser();
    }
    public ArrayList datasetReturner(ReadDataset readDataset) { 	
    	return readDataset.createDataset();
    }
}
