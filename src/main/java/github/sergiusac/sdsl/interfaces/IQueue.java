package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public interface IQueue<T> extends Iterable<T> {

    void enqueue(T item);

    T dequeue();

    T peek();

    boolean isEmpty();

    int getSize();
}
