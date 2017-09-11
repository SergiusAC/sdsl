package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IQueue;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class Queue<T> implements Iterable<T>, IQueue<T> {

    private LinkedList<T> list;
    private int size;

    public Queue() {
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
    public void enqueue(T item) {
        list.addBack(item);
        size++;
    }

    @Override
    public T dequeue() {
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
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

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
