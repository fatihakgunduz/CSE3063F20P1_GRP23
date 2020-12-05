import java.util.ArrayList;
import java.util.*;

public class RandomLabellingClass extends User {
	
	public RandomLabellingClass(int id, int password, String userName, String userType) {
		super(id, password, userName, userType);
		// TODO Auto-generated constructor stub
	}

	public void randomlyLabel(Dataset dataset){
		Random random = new Random();
		
		
		int k = 0;
		Label label = new Label();
		
		while(dataset.instanceList.size() != k && dataset.getInstanceList().get(k) != null) {
			int i = 0;
		
			while(i < dataset.getMaxLabelsPerInstance()) {
				if(random.nextInt(2)==1) {
					label = dataset.getLabelList().get(random.nextInt(dataset.getLabelList().size()));			
					dataset.getInstanceList().get(k).getLabelList().add(label);
					for(int x = 0; x<dataset.getLabelList().size(); x++) {
						if(label.getLabelID() == dataset.getLabelList().get(x).getLabelID()) {
							dataset.getLabelList().get(x).getInstanceList().add(dataset.getInstanceList().get(k));
						}
					}
				}
				i++;
			}
			k++;
		}
	}

 public void labelIt(Dataset dataset) {
	 int x = dataset.instanceList.size();
	 int y = dataset.labelList.size();
	 for (int i = 0 ; i<x; i++) {
		 for (int j =0 ; j<y ; j++) {
			 
		 }
	 }
 }




}
