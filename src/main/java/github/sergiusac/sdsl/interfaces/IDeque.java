package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public interface IDeque<T> {

    void pushFront(T item);

    T popFront();

    void pushBack(T item);

    T popBack();

    T peekFront();

    T peekBack();

    boolean isEmpty();
}
