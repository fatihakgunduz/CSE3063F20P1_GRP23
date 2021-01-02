import java.util.Scanner;

public class HumanLabel {
	private User user;
	private int firstEnter = 0;

	public HumanLabel(User user) {
		super();
		this.user = user;
	}
	
	public void labelling() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Did you label anything before? (yes or no)");
		String lab = sc.nextLine();
		String con = "no";
		if(lab == "yes") {
		System.out.println("Would you like to continue where you left? (yes or no)");
		con = sc.nextLine();
		}
		for(int i = 0; i < user.getDataset().size(); i++) {
			System.out.println("DATASET " + (i + 1));
			System.out.println("\nLABEL LIST");
			for(int j = 0; j < user.getDataset().get(i).getLabelList().size(); j++) {
				System.out.println("Label id: " + user.getDataset().get(i).getLabelList().get(j).getLabelID() + " Label Text: " + user.getDataset().get(i).getLabelList().get(j).getLabelText());
			}
			for(int k = 0; k < user.getDataset().get(i).getInstanceList().size(); k++) {	
					if(con == "yes") {
						if(user.getDataset().get(i).getInstanceList().get(k).getLabelList() == null) {
							System.out.println("\nInstance id: " + user.getDataset().get(i).getInstanceList().get(k).getInstanceId() + " Instance Text: " + user.getDataset().get(i).getInstanceList().get(k).getInstanceText());
							System.out.println("\nYou can select up to " +  user.getDataset().get(i).getMaxLabelsPerInstance() + " labels per instance");
							System.out.println("Please select labels between 1 - " + user.getDataset().get(i).getLabelList().size() + " (if you don't want to enter new label press 0):");
							int p = 0;
							while(p < user.getDataset().get(i).getMaxLabelsPerInstance()){
							int selected = sc.nextInt();
							if(selected == 0) {
								break;
							}
							else if(selected <= user.getDataset().get(i).getLabelList().size() && selected > 0) {
								selected--;
								user.getDataset().get(i).getInstanceList().get(k).getLabelList().add(user.getDataset().get(i).getLabelList().get(selected));		
							}else {
								System.out.println("Please select between 1 - " + user.getDataset().get(i).getLabelList().size() + "! :");
								p--;
							}
							p++;
							}
						}
					}else if(con == "no"){
						if(firstEnter == 0) {
						for(int f = 0; f < user.getDataset().get(i).getInstanceList().size(); f++) {
							if(user.getDataset().get(i).getInstanceList().get(f).getLabelList() != null) {
								user.getDataset().get(i).getInstanceList().get(f).getLabelList().clear();
								}
							}	
						}
							firstEnter++;
							System.out.println("\nInstance id: " + user.getDataset().get(i).getInstanceList().get(k).getInstanceId() + " Instance Text: " + user.getDataset().get(i).getInstanceList().get(k).getInstanceText());
							System.out.println("\nYou can select up to " +  user.getDataset().get(i).getMaxLabelsPerInstance() + " labels per instance");
							System.out.println("Please select labels between 1 - " + user.getDataset().get(i).getLabelList().size() + " (if you don't want to enter new label press 0):");
							int p = 0;
							while(p < user.getDataset().get(i).getMaxLabelsPerInstance()){
							int selected = sc.nextInt();
							if(selected == 0) {
								break;
							}
							else if(selected <= user.getDataset().get(i).getLabelList().size() && selected > 0) {
								selected--;
								user.getDataset().get(i).getInstanceList().get(k).getLabelList().add(user.getDataset().get(i).getLabelList().get(selected));		
							}else {
								System.out.println("Please select between 1 - " + user.getDataset().get(i).getLabelList().size() + "! :");
								p--;
							}
							p++;
						}
						
							
					}
				
				
			
			}
		}
		
	}
}
