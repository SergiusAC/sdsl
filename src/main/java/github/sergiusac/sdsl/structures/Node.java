package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.INode;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class Node<T> implements INode<T> {

    private T item;
    private Node<T> next;
    private Node<T> prev;

    public Node() {
        item = null;
        next = prev = null;
    }

    public Node(T item) {
        this.item = item;
        this.next = this.prev = null;
    }

    public Node(T item, Node<T> next, Node<T> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return item != null ? item.equals(node.item) : node.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
