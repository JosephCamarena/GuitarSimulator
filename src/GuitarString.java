import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

// Joseph Camarena
// jc0588321@swccd.edu
// 0588321
//https://introcs.cs.princeton.edu/java/assignments/guitar.html

public class GuitarString implements GuitarStringInterface {
	
	public int tic_called = 0;
	public int capacity;
	private RingBuffer guitarStringN;
	
	GuitarString(double frequency) {

		capacity = (int)( Math.ceil( 44100.0 / frequency ) );
		guitarStringN = new RingBuffer( capacity );
		for( int i = 0; i<capacity-1; i++)
			guitarStringN.enqueue(0);

	}
	
    GuitarString(double[] init) {
    	
    	RingBuffer guitarStringArray= new RingBuffer( init.length );
    
    }
    public void pluck() {
   
    	for( int i = 0; i < this.capacity; i++ )
    	{
    		//random val in the range -.5 to +.5
    		double rand = Math.random() - .5; 
    		guitarStringN.dequeue();
    		guitarStringN.enqueue( rand );
    	}
    }
    public void tic() {
    	
    	++tic_called;
    	//Karplus-Strong update
    	guitarStringN.enqueue( (guitarStringN.dequeue() + guitarStringN.peek()) / 2 * .994 );
    	
    }
    public double sample() {
    	
        return guitarStringN.peek();
        
    }
    public int time() {
    	
    	return tic_called;
    	
    }
	
}