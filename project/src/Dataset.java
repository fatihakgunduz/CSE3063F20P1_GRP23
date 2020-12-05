import java.text.SimpleDateFormat;
import java.util.*;
public class Dataset {

	      private long datasetId;
	      private String datasetName;
	      private long maxLabelsPerInstance;
	      private ArrayList<Label> labelList = new ArrayList<Label>();
	      private ArrayList<Instance> instanceList = new ArrayList<Instance>();
		
	      
	     
	      
	      
	    public Dataset(long datasetId, String datasetName, long maxLabelsPerInstance) {
	
			this.datasetId = datasetId;
			this.datasetName = datasetName;
			this.maxLabelsPerInstance = maxLabelsPerInstance;
		   
	    }
		
	    
	    public String getCurrentTimeStamp() {
	        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	        Date now = new Date();
	        String strDate = sdfDate.format(now);
	        return strDate;
	    }
	    
	    
	    
	    public void createLabel(long labelId,String labelText) {
	    	
	    	Label label = new Label(labelId,labelText);
	    	labelList.add(label);
	    
	    }
	    	    
	    
	    public void createInstance(long instanceId,String labelName) {
	    	Instance instance = new Instance(instanceId, labelName);
	        instanceList.add(instance);
	    }
          
	    
	    
	    public long getDatasetId() {
			return datasetId;
		}
		public void setDatasetID(long datasetId) {
			this.datasetId = datasetId;
		}
		public String getDatasetName() {
			return datasetName;
		}
		public void setDatasetName(String datasetName) {
			this.datasetName = datasetName;
		}
		public long getMaxLabelsPerInstance() {
			return maxLabelsPerInstance;
		}
		public void setMaxLabelsPerInstance(long maxLabelsPerInstance) {
			this.maxLabelsPerInstance = maxLabelsPerInstance;
		}
		public ArrayList<Label> getLabelList() {
			return labelList;
		}
		public void setLabelList(ArrayList<Label> labelList) {
			this.labelList = labelList;
		}
		public ArrayList<Instance> getInstanceList() {
			return instanceList;
		}
		public void setInstanceList(ArrayList<Instance> instanceList) {
			this.instanceList = instanceList;
		}
	      
	      
	
	
	
	
	
	
	
	
}
