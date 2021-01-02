import java.util.ArrayList;

public class HumanUser extends User{

	public HumanUser(long id, String userName, String password, ArrayList<Long> datasetIds) {
		super(id, userName, password, datasetIds);
		// TODO Auto-generated constructor stub
	}

	public HumanUser(String userName, long id, String password, ArrayList<Dataset> dataset) {
		super(userName, id, password, dataset);
		// TODO Auto-generated constructor stub
	}

}
