

import java.util.ArrayList;


public class Label {
    private long labelID;
    private String labelText;
    private ArrayList<Instance> instanceList = new ArrayList<Instance>();
    public Label(long labelID, String labelText){
        this.labelID=labelID;
        this.labelText=labelText;
    }
    
    public Label() {
    	
    }
    public long getLabelID() {
        return labelID;
    }

    public ArrayList<Instance> getInstanceList() {
		return instanceList;
	}

	public void setInstanceList(ArrayList<Instance> instanceList) {
		this.instanceList = instanceList;
	}

	public String getLabelText() {
        return labelText; //umlde return type long yazılmış
    }

    public void setLabelID(long labelID) {
        this.labelID = labelID; }

    public void setLabelText(String labelText) {
        this.labelText = labelText; }

    public void addInstance(Instance instance){
        instanceList.add(instance);
    }
    public Instance getInstance(long index){
         return instanceList.get((int)index);
    }
   // public void prlongInstance(long index){
     //   System.out.prlongf("Instance Id: %d\n", instanceList.get(index).getInstanceId);
       // System.out.prlongf("Instance Id: %s\n", instanceList.get(index).getInstanceText);
    //}
    public void removeInstance(long index){
        instanceList.remove((int) index);
    }
    public void clearInstance(){
        instanceList.clear();
    }
    public long instanceNumber(){
        return instanceList.size();
    }
    //public void prlongInstances(){
      //  for (Instance i : instanceList){
        //    System.out.prlongf("Instance ID: %d\n", i.getInstanceId);
          //  System.out.prlongf("Instance Text: %s\n",i.getInstanceText);
      // }
    }
