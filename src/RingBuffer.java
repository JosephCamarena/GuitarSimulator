// Joseph Camarena
// jc0588321@swccd.edu
// 0588321

import java.util.NoSuchElementException;

public class RingBuffer implements RingBufferInterface {
	private Double[]    queue;
    private int         first, last, size, max_cap;

    RingBuffer(int capacity) {
        max_cap = capacity;
        queue = new Double[capacity + 1];
        first = capacity+1;
        last = 0;
        size = 0;
    }

    RingBuffer(){
        max_cap = 5;
        queue = new Double[max_cap +1];
        first = max_cap +1;
        last = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == max_cap);
    }

    public void enqueue(double item) {
        if( isFull() ) throw new IllegalStateException( "Cannot add to a full queue");
        queue[last++] = item;
        last = last % queue.length;
        size++;
    }

    public double dequeue() {
        if( isEmpty() ) throw new NoSuchElementException( "Cannot remove from empty queue");
        first = first % queue.length;
        double data = queue[first];   //  item to return
        queue[first++] = null;
        size--;
        return data;
    }

    public double peek() {
        if( isEmpty() ) throw new NoSuchElementException("Cannot peek into empty queue");
        first = first % queue.length;
        return queue[first];
    }

    public int size() {
        return this.size;
    }
}