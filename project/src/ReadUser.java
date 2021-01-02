import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadUser {
	JSONArray users;
	ArrayList<User> userList = new ArrayList<User>();
	public ReadUser(JSONArray users) {
		super();
		this.users = users;
	}
	
	
	public ArrayList createUser() {
		for (Object x : users)
        {
            JSONObject user = (JSONObject) x;
            
            JSONArray UserDatasets = (JSONArray)user.get("datasets");

            long userId = (long)user.get("UserId");
            String userName = (String)user.get("UserName");
            long humanChecker = (long)user.get("HumanChecker");
            Double checkProbability = (Double)user.get("ConsistencyCheckProbability");
            String password = (String)user.get("password");
            
            ArrayList<Long> datasetIds = new ArrayList<Long>();
            
            for(Object f : UserDatasets)
            {
           	JSONObject  dataset= (JSONObject) f;
           	long datasetID = (long)dataset.get("User_Dataset_ID");

           	datasetIds.add(datasetID);
            }            
          
            if(humanChecker == 1) {
            	HumanUser usr = new HumanUser(userId, userName, password, datasetIds);
            	 userList.add(usr);
            }else {
            	BotUser usr = new BotUser(userId, userName, password, datasetIds);
                userList.add(usr);
            }
            
         
          /*  System.out.println("User Id: " + userId);
            System.out.println("User name: " + userName);
            System.out.println("Users Dataset Id: " + datasetIds.get(0));*/
            
        }
		return userList;
	}
}
