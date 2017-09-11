package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IStack;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class Stack<T> implements Iterable<T>, IStack<T> {

    private LinkedList<T> list;
    private int size;

    public Stack() {
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
    public void push(T item) {
        list.addFront(item);
        size++;
    }

    @Override
    public T pop() {
        T item = list.getHead().getItem();
        list.removeFront();
        size--;
        return item;
    }

    @Override
    public T peek() {
        return list.getHead().getItem();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

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
