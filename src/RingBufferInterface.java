// Joseph Camarena
// jc0588321@swccd.edu
// 0588321

public interface RingBufferInterface {
	
    int size();                    // return number of items currently in the buffer
    boolean isEmpty();                 // is the buffer empty (size equals zero)?
    boolean isFull();                  // is the buffer full  (size equals capacity)?
    void enqueue(double x);         // add item x to the end
    double dequeue();                 // delete and return item from the front
    double peek();                    // return (but do not delete) item from the front
    
}
