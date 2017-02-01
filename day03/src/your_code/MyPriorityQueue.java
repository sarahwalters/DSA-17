package your_code;

import java.util.List;
import java.util.ArrayList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {
    private List<T> elts;

    public MyPriorityQueue() {
        this.elts = new ArrayList<>();
    }

    public void enqueue(T item) {
        // Maintain list in sorted order
        for (int i = 0; i < this.elts.size(); i++) {
            if (elts.get(i).compareTo(item) > 0) {
                elts.add(i, item);
                return;
            }
        }
        elts.add(item);
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public T dequeueMax() {
        return elts.remove(elts.size() - 1);
    }

}