import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class User  {
	
	private long id;
	private String userName;
	private String password;
	private ArrayList<Dataset> dataset = new ArrayList<Dataset>();
	private ArrayList<Instance> labeled = new ArrayList<Instance>();
	
	public User() {
		super();
	}
	private ArrayList<Long> datasetIds = new ArrayList<Long>();
	
	


	public User(long id,String userName,String password,ArrayList<Long> datasetIds) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.datasetIds = datasetIds;
	}
	public User(String userName, long id, String password, ArrayList<Dataset> dataset) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.dataset = dataset;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public ArrayList<Dataset> getDataset() {
		return dataset;
	}


	public void setDataset(ArrayList<Dataset> dataset) {
		this.dataset = dataset;
	}
	
	public ArrayList<Instance> getLabeled() {
		return labeled;
	}


	public void setLabeled(ArrayList<Instance> labeled) {
		this.labeled = labeled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Long> getDatasetIds() {
		return datasetIds;
	}
	public void setDatasetIds(ArrayList<Long> datasetIds) {
		this.datasetIds = datasetIds;
	}


}
