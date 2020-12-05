import java.util.ArrayList;
public class Label {
    private long labelID;
    private String labelText;
    ArrayList<Instance> instanceList = new ArrayList<Instance>();
    public Label(long labelID, String labelText){
        this.labelID=labelID;
        this.labelText=labelText; }
    public long getLabelID() {
        return labelID;
    }
    public String getLabelText() { return labelText; }
    public ArrayList<Instance> getInstanceList() {
		return instanceList;
	}
	public void setLabelID(long labelID) { this.labelID = labelID; }
    public void setLabelText(String labelText) { this.labelText = labelText; }
    public void addInstance(Instance instance){ instanceList.add(instance); }
    public Instance getInstance(long index){ return instanceList.get((int)index); }
    public void removeInstance(long index){ instanceList.remove((int) index); }
    public void clearInstance(){ instanceList.clear(); }