import org.json.simple.parser.JSONParser;
public class User {
	
	private long id;
	private long password;
	private String userName;
	private String userType;
	
	
	
	public User(long id, long password, String userName, String userType) {
		super();
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}
