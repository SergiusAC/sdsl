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
        if (isEmpty()) {
            head = new Node<>(item);
            tail = head;
        } else {
            Node<T> oldHead = head;
            head = new Node<>(item, oldHead, null);
            oldHead.setPrev(head);
        }
        size++;
    }

    public void addBack(T item) {
        if (isEmpty()) {
            head = new Node<>(item);
            tail = head;
        } else {
            Node<T> oldTail = tail;
            tail = new Node<>(item, null, oldTail);
            oldTail.setNext(tail);
        }
        size++;
    }

    public void removeFront() {
        if (!isEmpty()) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            size--;
        }
    }

    public void removeBack() {
        if (!isEmpty()) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
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