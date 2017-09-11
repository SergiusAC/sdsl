package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public interface IStack<T> {

    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();
}
