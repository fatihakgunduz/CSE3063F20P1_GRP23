import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Output {
	private ArrayList<Dataset> datasetList = new ArrayList<Dataset>();
	private ArrayList<User> userList = new ArrayList<User>();
	
public Output(ArrayList<Dataset> datasetList, ArrayList<User> userList) {
		super();
		this.datasetList = datasetList;
		this.userList = userList;
	}

public void writeOutput() {
    JSONObject o = new JSONObject();
  
    JSONArray cla = new JSONArray();
    
    for(User u: userList) {
   	 datasetList = u.getDataset();
   	 for(Dataset d: datasetList) {
   		 
   		 o.put("dataset id", d.getDatasetId());
   		 o.put("dataset name", d.getDatasetName());
   		 o.put("maximum number of labels per instance", d.getMaxLabelsPerInstance());
   		 JSONArray l = new JSONArray();
   		 JSONArray inst = new JSONArray();
        
   		 for ( int i=0 ;i<d.getLabelList().size();i++) {
   			 l.add(d.getLabelList().get(i).labelToJSON());
   		 }
      
   		 for ( int j=0 ;j <d.getInstanceList().size();j++) {
   			 inst.add(d.getInstanceList().get(j).instanceToJSON());
   		 }
          
        
   		 o.put("class labels", l);
   
   		 o.put("instances", inst);
       	
   		 
        
   		 for(int i=0 ; i<d.getInstanceList().size();i++) {
   			 JSONArray clids = new JSONArray();
   			 JSONObject temp = new JSONObject(); 	 
   			 temp.put("instance id",d.getInstanceList().get(i).getInstanceId());
   			 temp.put("user id :", u.getId());
   			 temp.put("datetime",d.getCurrentTimeStamp());
       	 
   			 for(int j=0; j<d.getInstanceList().get(i).getLabelList().size();j++) {
   				 clids.add(d.getInstanceList().get(i).getLabelList().get(j).getLabelID());
   				 //System.out.println(d.getInstanceList().get(i).getLabelList().get(j).getLabelID());
   			 }    	 
   			 temp.put("class label ids",clids);
   			 cla.add(temp);
   			 o.put("class label assignments",cla);
   		 }
   	
   	 }   
    }  
    
   	    JsonParser parser1 = new JsonParser();
   	    JsonObject json = parser1.parse(o.toString()).getAsJsonObject();

   	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
   	    String prettyJson = gson.toJson(json);

   	
    
   	   try (FileWriter file = new FileWriter("output.json")) {
		 
		 	file.write(prettyJson);
		 	file.flush();

	 	}catch (IOException e) {
	 		e.printStackTrace();
	 	}
	}
}
