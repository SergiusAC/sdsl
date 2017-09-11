package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IDeque;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class Deque<T> implements Iterable<T>, IDeque<T> {

    private LinkedList<T> list;
    private int size;

    public Deque() {
        list = new LinkedList<>();
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return size;
    }

    public LinkedList<T> toLinkedList() {
        return list;
    }

    @Override
    public void pushFront(T item) {
        list.addFront(item);
        size++;
    }

    @Override
    public void pushBack(T item) {
        list.addBack(item);
        size++;
    }

    @Override
    public T popFront() {
        T item = list.getHead().getItem();
        list.removeFront();
        size--;
        return item;
    }

    @Override
    public T popBack() {
        T item = list.getTail().getItem();
        list.removeBack();
        size--;
        return item;
    }

    @Override
    public T peekFront() {
        return list.getHead().getItem();
    }

    @Override
    public T peekBack() {
        return list.getTail().getItem();
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    public Iterator<T> descendingIterator() {
        return new DequeDescendingIterator();
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

    private class DequeDescendingIterator implements Iterator<T> {

        Node<T> currentNode = list.getTail();

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T item = currentNode.getItem();
            currentNode = currentNode.getPrev();
            return item;
        }
    }
}
