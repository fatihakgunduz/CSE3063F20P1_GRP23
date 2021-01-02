import java.util.ArrayList;

public class DatasetAssigner {
	private ArrayList<Dataset> datasetList = new ArrayList<Dataset>();
	private ArrayList<User> userList = new ArrayList<User>();
	
	public DatasetAssigner(ArrayList<Dataset> datasetList, ArrayList<User> userList) {
		super();
		this.datasetList = datasetList;
		this.userList = userList;
	}
	
	public ArrayList datasetAssigner(){
		for(int i = 0; i < datasetList.size(); i++) {
		//	System.out.println("EPRUEANU  " + datasetList.get(i).getDatasetId());
		}
		for(int i = 0; i < userList.size(); i++) {
		//	System.out.println("LOBJANIDJZE  " + userList.get(i).getId());
		}
		for(int i = 0; i < userList.size();i++) {
        	for(int j = 0; j < userList.get(i).getDatasetIds().size();j++) {
        		for(int k = 0; k < datasetList.size(); k++) {
        			//System.out.println("BERAT OZDEMIR ASSIGN ETMEDIM " + userList.get(i).getDatasetIds().get(j)); 
        			if(userList.get(i).getDatasetIds().get(j) == datasetList.get(k).getDatasetId()) {
        				userList.get(i).getDataset().add(datasetList.get(k));
        				//System.out.println("ZEKI YAVRU ASSIGN ETTIM " + userList.get(i).getDatasetIds().get(j)); 
        			 }
        		}
        	}
        }
        return userList;
	}
}
