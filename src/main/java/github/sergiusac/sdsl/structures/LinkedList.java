package github.sergiusac.sdsl.structures;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void addFront(T item) {
        Node<T> tmp = new Node<>(item, head, null);
        if (head != null)
            head.setPrev(tmp);
        head = tmp;
        if (tail == null)
            tail = tmp;
        size++;
    }

    public void addBack(T item) {
        Node<T> tmp = new Node<>(item, null, tail);
        if (tail != null)
            tail.setNext(tmp);
        tail = tmp;
        if (head == null)
            head = tmp;
        size++;
    }

    public void removeFront() {
        if (head != null) {
           Node<T> prev = head;
           head = head.getNext();
           if (head != null)
               head.setPrev(null);
           if (prev == tail)
               tail = null;
           size--;
        }
    }

    public void removeBack() {
        if (tail != null) {
            Node<T> next = tail;
            tail = tail.getPrev();
            if (tail != null)
                tail.setNext(null);
            if (next == head)
                head = null;
            size--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        Node<T> currentNode = head;

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
