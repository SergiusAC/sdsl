package github.sergiusac.sdsl.structures;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class Deque<T> implements Iterable<T> {

    private LinkedList<T> list;
    private int size;

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return size;
    }

    public LinkedList<T> toLinkedList() {
        return list;
    }

    public void pushFront(T item) {
        list.addFront(item);
        size++;
    }

    public void pushBack(T item) {
        list.addBack(item);
        size++;
    }

    public T popFront() {
        T item = list.getHead().getItem();
        list.removeFront();
        size--;
        return item;
    }

    public T popBack() {
        T item = list.getTail().getItem();
        list.removeBack();
        size--;
        return item;
    }

    public T getFirstItem() {
        return list.getHead().getItem();
    }

    public T getLastItem() {
        return list.getTail().getItem();
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        Node<T> currentNode = list.getHead();

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T item = currentNode.getItem();
            currentNode = currentNode.getNext();
            return item;
        }
    }
}
