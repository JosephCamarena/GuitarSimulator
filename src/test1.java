
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((int)Math.ceil( 44100.0 / 399 ));
		
		int neg_ctr = 0, pos_ctr = 0;
		
        for (int i = 0; i < 100; i++) { 
        	
            double rand = Math.random() - .5; 
            
            if(rand < 0) neg_ctr++;
            if(rand > 0) pos_ctr++;
            
            if(rand < -.5) {
            	System.out.println("Oops, out of negative range");
            	break;
            }
            if(rand > .5) {
            	System.out.println("Oops, out of positive range");
            	break;
            }
            
            
            System.out.println(rand); 
        }
        System.out.println();
        System.out.println("Negatives total: " + neg_ctr); 
        System.out.println("Positives total: " + pos_ctr);
        
	}
}
