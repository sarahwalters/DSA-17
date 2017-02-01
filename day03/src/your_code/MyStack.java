package your_code;

import ADTs.StackADT;
import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack<T extends Comparable<? super T>> implements StackADT<T> {
    private LinkedList<T> elts;
    private LinkedList<T> max;

    public MyStack() {
        this.elts = new LinkedList<>();
        this.max = new LinkedList<>();
    }

    @Override
    public void push(T e) {
        this.elts.addFirst(e);
        if (this.max.size() == 0 || this.max.getFirst().compareTo(e) <= 0) {
            this.max.addFirst(e);
        }
    }

    @Override
    public T pop() {
        T toRemove = this.elts.removeFirst();
        if (this.max.getFirst().equals(toRemove)) {
            this.max.removeFirst();
        }
        return toRemove;
    }

    @Override
    public boolean isEmpty() {
        return this.elts.size() == 0;
    }

    @Override
    public T peek() {
        return this.elts.getFirst();
    }

    public T maxElement() {
        return max.getFirst();
    }
}
