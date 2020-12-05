import java.util.ArrayList;

public class Instance {
    private  long instanceId;
    private String instanceText;
    ArrayList<Label> labelList = new ArrayList<Label>();
    
    public Instance(long instanceId, String instanceText) {
        this.instanceId = instanceId;
        this.instanceText = instanceText;
        
    }

    public long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceText() {
        return instanceText;
    }

    public void setInstanceText(String instanceText) {
        this.instanceText = instanceText;
    }

    public ArrayList<Label> getLabelList() {
        return labelList;
    }

  
    public void setLabelList(ArrayList<Label> labelList) {
        this.labelList = labelList;
    }
}
