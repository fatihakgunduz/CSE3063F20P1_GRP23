import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadDataset {
	 JSONArray datasets;
	 ArrayList<Dataset> datasetList = new ArrayList<Dataset>();

	public ReadDataset(JSONArray datasets) {
		super();
		this.datasets = datasets;
	}
	 
	public ArrayList createDataset() {
		JSONParser parser = new JSONParser();
		try {
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
      
            // System.out.println("Dataset Id: " + datasetId);
             //System.out.println("Dataset name: " + datasetName);
             //System.out.println("maximum number of labels per instance: " + max);
             //System.out.println("Labels :" + labels);
          
             for (Object o : labels)
             {
               JSONObject label = (JSONObject) o;

          	   long labelId = (long)label.get("label id");
          	   String labelText = (String)label.get("label text");
        	   Label labelTemp = new Label(labelId,labelText);
               dataset.getLabelList().add(labelTemp);
        	   //System.out.println(labelId);
               //System.out.println(labelText);
     
             }
             
             for (Object o : instances)
             {
            	 JSONObject ins = (JSONObject) o;

              	 long instanceId = (long)ins.get("id");
                 String instance = (String)ins.get("instance");
        
                 Instance instanceTemp = new Instance(instanceId,instance);
                 dataset.getInstanceList().add(instanceTemp);
                //System.out.println(instanceId);
                 //System.out.println(instance);
     
             } 
             
             datasetList.add(dataset);
         }
		
		}catch(Exception e) {
	    	e.printStackTrace();
	    }
		return datasetList;
	}
	
}
