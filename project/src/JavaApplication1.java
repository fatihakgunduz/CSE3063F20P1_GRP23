

public class JavaApplication1 {
   public static void main(String[] args) {
	    
    	 String config = "config.json";
         Input input = new Input(config);
         DatasetAssigner datasetAssigner = new DatasetAssigner(input.datasetReturner(input.datasetObjectReturner()),input.userReturner(input.userObjectReturner()));
         Assignment assign = new Assignment(input.datasetReturner(input.datasetObjectReturner()),datasetAssigner.datasetAssigner());
         assign.labellingMechanismDecider();
         assign.outputCaller();
         
         
         
         
   
   }
}