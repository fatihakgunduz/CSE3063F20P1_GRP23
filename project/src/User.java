import org.json.simple.parser.JSONParser;
public class User {
	
	private long id;
	private String userName;
	private long datasetId;
	
	
	
	public User(long id,String userName, long datasetId) {
		super();
		this.id = id;
		this.userName = userName;
		this.datasetId = datasetId;
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

	public long getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(long datasetId) {
		this.datasetId = datasetId;
	}
}
