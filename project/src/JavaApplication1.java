import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaApplication1 {
   public static void main(String[] args) {
	  
	   JSONParser parser = new JSONParser();
      try {
    	 
         Object cfg = parser.parse(new FileReader("config.json"));
         
         JSONObject jsonObject2 = (JSONObject)cfg;

        
         
         JSONArray datasets = (JSONArray)jsonObject2.get("Datasets");
         
         JSONArray users = (JSONArray)jsonObject2.get("Users");
         
         ArrayList<Dataset> datasetList = new ArrayList<Dataset>();
         
         ArrayList<User> userList = new ArrayList<User>();
       
      
         for (Object x : datasets)
         {
             JSONObject dtsts = (JSONObject) x;

             String datasetsStr = (String)dtsts.get("Dataset_Path");
             long datasetsId = (long)dtsts.get("Dataset_Id");
             Object obj = parser.parse(new FileReader(datasetsStr));
             JSONObject jsonObject = (JSONObject)obj;
             
             long datasetId = (long)jsonObject.get("dataset id");
             String datasetName = (String)jsonObject.get("dataset name");
             long max = (long)jsonObject.get("maximum number of labels per instance");
             
             
             Dataset dataset = new Dataset(datasetId,datasetName,max);
             
             
             
             JSONArray labels = (JSONArray)jsonObject.get("class labels");

             JSONArray instances = (JSONArray)jsonObject.get("instances");
      
             System.out.println("Dataset Id: " + datasetId);
             System.out.println("Dataset name: " + datasetName);
             System.out.println("maximum number of labels per instance: " + max);
             //System.out.println("Labels :" + labels);
          
             for (Object o : labels)
             {
               JSONObject label = (JSONObject) o;

          	   long labelId = (long)label.get("label id");
          	   String labelText = (String)label.get("label text");
        	   Label labelTemp = new Label(labelId,labelText);
               dataset.getLabelList().add(labelTemp);
        	   System.out.println(labelId);
               System.out.println(labelText);
     
             }
             
             for (Object o : instances)
             {
            	 JSONObject ins = (JSONObject) o;

              	 long instanceId = (long)ins.get("id");
                 String instance = (String)ins.get("instance");
        
                 Instance instanceTemp = new Instance(instanceId,instance);
                 dataset.getInstanceList().add(instanceTemp);
                 System.out.println(instanceId);
                 System.out.println(instance);
     
             } 
             
             datasetList.add(dataset);
         }
        
         
         
         for (Object x : users)
         {
             JSONObject user = (JSONObject) x;
             
             JSONArray UserDatasets = (JSONArray)user.get("datasets");

             long userId = (long)user.get("UserId");
             String userName = (String)user.get("UserName");
             
             ArrayList<Long> datasetsId = new ArrayList<Long>();
             
             for(Object f : UserDatasets)
             {
            	JSONObject  dataset= (JSONObject) f;
            	long datasetID = (long)dataset.get("User_Dataset_ID");
 
            	datasetsId.add(datasetID);
             }
             
             ArrayList<Dataset> dtstsArray = new ArrayList<Dataset>();
             
             for(int ankaraliNamik = 0; ankaraliNamik < datasetList.size(); ankaraliNamik++) {
            	 for(int cubukluYasar = 0; cubukluYasar < datasetsId.size(); cubukluYasar++) {
            		 if(datasetsId.get(cubukluYasar) == datasetList.get(ankaraliNamik).getDatasetId()) {
            			 dtstsArray.add(datasetList.get(ankaraliNamik));
            		 }
            	 }
             }
             
             User usr = new User(userId, userName, dtstsArray);
             userList.add(usr);
          
             System.out.println("User Id: " + userId);
             System.out.println("User name: " + userName);
             System.out.println("Users Dataset Id: " + datasetsId.get(0));
             
         }
         for(int ibocan = 0; ibocan < userList.size(); ibocan++) {
        	 RandomLabellingClass user = new RandomLabellingClass(userList.get(ibocan)); 
        	 user.randomlyLabel(userList.get(ibocan));
        	 
        	 for (Instance ins : datasetList.get(0).getInstanceList()) {
        		 
                 for (Label lab : ins.getLabelList()) {
                	 System.out.print(userList.get(ibocan).getUserName() + "\t ------> \t");
                     System.out.println(ins.getInstanceId() + " " + lab.getLabelID() + " " + lab.getLabelText());
                 }

             }
         }
        
         
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
        				 System.out.println(d.getInstanceList().get(i).getLabelList().get(j).getLabelID());
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

		 } catch (IOException e) {
			 e.printStackTrace();
		 }  
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}