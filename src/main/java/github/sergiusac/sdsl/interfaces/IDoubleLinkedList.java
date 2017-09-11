package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public interface IDoubleLinkedList<T> {

    void addFront(T item);

    void removeFront();

    void addBack(T item);

    void removeBack();

    INode<T> getHead();

    INode<T> getTail();
}
