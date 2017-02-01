package your_code;

import ADTs.QueueADT;
import java.util.LinkedList;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue<T> implements QueueADT<T> {

    private LinkedList<T> elts;

    public MyQueue() {
        this.elts = new LinkedList<>();
    }

    @Override
    public void enqueue(T item) {
        this.elts.addLast(item);
    }

    @Override
    public T dequeue() {
        return this.elts.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.elts.size() == 0;
    }

    @Override
    public T front() {
        return this.elts.getFirst();
    }
}