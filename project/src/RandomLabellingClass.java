import java.util.ArrayList;
import java.util.*;

public class RandomLabellingClass extends User {
	
	public RandomLabellingClass(User user) {
		super(user.getId(),user.getUserName(),user.getDataset());
		// TODO Auto-generated constructor stub
	}
	
	public void randomlyLabel(User user){
		Random random = new Random();
		int returnInstanceProbability = 10;			//Simdilik 10 dedik configden cekilecek
		int k = 0;
		int count = 0;
		Label label = new Label();
		for(int ankaraliTurgut = 0; ankaraliTurgut < user.getDataset().size(); ankaraliTurgut++) {
			//	System.out.println("HATA 1");
			while(user.getDataset().get(ankaraliTurgut).getInstanceList().size() != k && user.getDataset().get(ankaraliTurgut).getInstanceList().get(k) != null) {
				//System.out.println("HATA 2");
				int i = 0;
				if(count == 0) {
					while(i < user.getDataset().get(ankaraliTurgut).getMaxLabelsPerInstance()) {	
						//System.out.println("HATA 3");
						if(random.nextInt(2)==1) {
							//	System.out.println("HATA 4");
						label = user.getDataset().get(ankaraliTurgut).getLabelList().get(random.nextInt(user.getDataset().get(ankaraliTurgut).getLabelList().size()));			
						user.getDataset().get(ankaraliTurgut).getInstanceList().get(k).getLabelList().add(label);
						user.getLabeled().add(user.getDataset().get(ankaraliTurgut).getInstanceList().get(0));
						/*for(int x = 0; x<dataset.getLabelList().size(); x++) {
							if(label.getLabelID() == dataset.getLabelList().get(x).getLabelID()) {
								dataset.getLabelList().get(x).getInstanceList().add(dataset.getInstanceList().get(k));
							}*/
						count++;
						i++;
						}
					}
				}else {
					//System.out.println("HATA 5");
						int returnProbability = random.nextInt(99) + 1;
						if(returnProbability < returnInstanceProbability) {
							//System.out.println("HATA 6");
							int randomLabeledInstance = random.nextInt(user.getLabeled().size());
							while(i < user.getDataset().get(ankaraliTurgut).getMaxLabelsPerInstance()) {
								//System.out.println("HATA 7");
								if(random.nextInt(2)==1) {
									//System.out.println("HATA 8");
									label = user.getDataset().get(ankaraliTurgut).getLabelList().get(random.nextInt(user.getDataset().get(ankaraliTurgut).getLabelList().size()));
									user.getDataset().get(ankaraliTurgut).getInstanceList().get(randomLabeledInstance).getLabelList().add(label);	
						/*for(int x = 0; x<dataset.getLabelList().size(); x++) {
							if(label.getLabelID() == dataset.getLabelList().get(x).getLabelID()) {
								dataset.getLabelList().get(x).getInstanceList().add(dataset.getInstanceList().get(k));	*/
								}
							i++;
							}
						}else {
							//System.out.println("HATA 9");
							while(i < user.getDataset().get(ankaraliTurgut).getMaxLabelsPerInstance()) {
							//	System.out.println("HATA 10");
								if(random.nextInt(2) == 1) {
									//System.out.println("HATA 11");
									label = user.getDataset().get(ankaraliTurgut).getLabelList().get(random.nextInt(user.getDataset().get(ankaraliTurgut).getLabelList().size()));			
									user.getDataset().get(ankaraliTurgut).getInstanceList().get(k).getLabelList().add(label);
									user.getLabeled().add(user.getDataset().get(ankaraliTurgut).getInstanceList().get(k));
								}
							i++;
							}
						}
					}
						/*while(i < dataset.getMaxLabelsPerInstance()) {
							if(random.nextInt(2)==1) {
								label = dataset.getLabelList().get(random.nextInt(dataset.getLabelList().size()));			
								dataset.getInstanceList().get(k).getLabelList().add(label);
								for(int x = 0; x<dataset.getLabelList().size(); x++) {
									if(label.getLabelID() == dataset.getLabelList().get(x).getLabelID()) {
										dataset.getLabelList().get(x).getInstanceList().add(dataset.getInstanceList().get(k));	*/
				
	
			k++;			
			}
		}
	}
}
