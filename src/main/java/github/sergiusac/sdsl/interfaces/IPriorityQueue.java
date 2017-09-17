package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/16/17.
 */
public interface IPriorityQueue<K extends Comparable>
        extends Iterable<K> {

    void insert(K key);

    K pop();

    K top();

    boolean isEmpty();

    int getSize();
}
