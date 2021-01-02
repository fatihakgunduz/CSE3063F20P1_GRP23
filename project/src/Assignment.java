import java.util.ArrayList;

public class Assignment {
	 /* for(int ankaraliNamik = 0; ankaraliNamik < datasetList.size(); ankaraliNamik++) {
  	 for(int cubukluYasar = 0; cubukluYasar < datasetsId.size(); cubukluYasar++) {
  		 if(datasetsId.get(cubukluYasar) == datasetList.get(ankaraliNamik).getDatasetId()) {
  			 dtstsArray.add(datasetList.get(ankaraliNamik));
  		 }
  	 }
   }*/
	
	private ArrayList<Dataset> datasetList = new ArrayList<Dataset>();
	private ArrayList<User> userList = new ArrayList<User>();
	
	public Assignment(ArrayList<Dataset> datasetList, ArrayList<User> userList) {
		super();
		this.datasetList = datasetList;
		this.userList = userList;
	}
	
	public void labellingMechanismDecider() {
		Login login = new Login();
		login.loginInput();
		if(login.loginCheck(userList) == 0) {
			login.loginInputAgain();
		}
		long loginCheckID = login.loginCheck(userList);
		if(loginCheckID == -1) {
			randomLabel();
		}else {
			humanLabel(loginCheckID);
			
		}
	}
	
	public void randomLabel() {	 
		 for(int ibocan = 0; ibocan < userList.size(); ibocan++) {
			 
			 if(userList.get(ibocan) instanceof BotUser != false){
				 RandomLabellingClass user = new RandomLabellingClass(userList.get(ibocan)); 
	        	 user.randomlyLabel(userList.get(ibocan));}
	        	 /*for(Dataset dat : userList.get(ibocan).getDataset()) {
	        		// System.out.println("\nDEBUG DATASET");
	        		 for (Instance ins : dat.getInstanceList()) {
	        		 
	        		 	for (Label lab : ins.getLabelList()) {
	        		 		System.out.print(userList.get(ibocan).getUserName() + "\t ------> \t");
	        		 		System.out.println(ins.getInstanceId() + " " + lab.getLabelID() + " " + lab.getLabelText());
	                 	}
	                 
	             	}
	     } */
		 	
		 }
	}
	
	
	public void humanLabel(long id) {
		for(int kubat = 0; kubat < userList.size(); kubat++) {
			if(userList.get(kubat).getId() == id) {
				HumanLabel humanUser = new HumanLabel(userList.get(kubat));
				humanUser.labelling();
			}
		}
		
	}
	
	
	public void outputCaller() {
		Output output = new Output(datasetList, userList);
		output.writeOutput();
		/*for(int i = 0; i < userList.size(); i++) {
			System.out.println("DEBUG " + userList.get(i).getId());
		}*/
	}
	
	
}
