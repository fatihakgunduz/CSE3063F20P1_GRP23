import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaApplication1 {
   public static void main(String[] args) {
	  
	   JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader("CES3063F20_LabelingProject_Input-1.json"));
         Object cfg = parser.parse(new FileReader("config.json"));
         JSONObject jsonObject = (JSONObject)obj;
         JSONObject jsonObject2 = (JSONObject)cfg;

         long datasetId = (long)jsonObject.get("dataset id");
         String datasetName = (String)jsonObject.get("dataset name");
         long max = (long)jsonObject.get("maximum number of labels per instance");
         
         Dataset dataset = new Dataset(datasetId,datasetName,max);
         
         JSONArray labels = (JSONArray)jsonObject.get("class labels");

         JSONArray users = (JSONArray)jsonObject.get("Users");
        
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

          for (Object o : users)
          {
              JSONObject user = (JSONObject) o;

              long userId = (long)user.get("UserId");
              String userName = (String)user.get("UserName");
              long datasetsId = (long)user.get("datasets");
              User userTemp = new User(userId,userName,datasetsId);
              dataset.getUserList().add(userTemp);
              System.out.println(userId);
              System.out.println(userName);


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
         
        int userNumber =0;
        while (userNumber < dataset.getUserList().size()) {
            RandomLabellingClass user = new RandomLabellingClass(dataset.getUserList().get(userNumber));
            user.randomlyLabel(dataset);
            for (Instance ins : dataset.getInstanceList()) {

                for (Label lab : ins.getLabelList()) {
                    System.out.println(ins.getInstanceId() + " " + lab.getLabelID() + " " + lab.getLabelText());
                }

            }
        }
      
         
        
         JSONObject o = new JSONObject();
         o.put("dataset id", datasetId);
         o.put("dataset name", datasetName);
         o.put("maximum number of labels per instance", max);
         JSONArray l = new JSONArray();
         JSONArray inst = new JSONArray();
         for ( int i=0 ;i<labels.size();i++) {
         l.add(labels.get(i));
        
         }
       
         for ( int j=0 ;j <instances.size();j++) {
        	 inst.add(instances.get(j));
            
             }
           
         
         o.put("class labels", l);
         o.put("instances", inst);
        	
         JSONArray cla = new JSONArray();
         
         for(int i=0 ; i<instances.size();i++) {
        	 JSONArray clids = new JSONArray();
        	 JSONObject temp = new JSONObject();
        	 temp.put("instance id",dataset.getInstanceList().get(i).getInstanceId());
        	 temp.put("user id :",1);
        	 temp.put("datetime",dataset.getCurrentTimeStamp());
        	 
        	 for(int j=0; j<dataset.getInstanceList().get(i).getLabelList().size();j++) {
        		 clids.add(dataset.getInstanceList().get(i).getLabelList().get(j).getLabelID());
 
        	 }
        	 
        	 temp.put("class label ids",clids);
             cla.add(temp);
             o.put("class label assignments",cla);
         }
         
         try (FileWriter file = new FileWriter("output.json")) {
        			 
        	            file.write(o.toJSONString());
        	            file.flush();
        	 
        	        } catch (IOException e) {
        	            e.printStackTrace();
        	        } 
        		 
 		 
      
      } catch(Exception e) {
         e.printStackTrace();
      }
   
 
      
   
      
      
    
      
   }
              
          







}