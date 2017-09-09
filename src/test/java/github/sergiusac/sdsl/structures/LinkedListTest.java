package github.sergiusac.sdsl.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class LinkedListTest {
    @Test
    public void isEmpty() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(true, list.isEmpty());
        list.addBack("first string");
        assertEquals(false, list.isEmpty());
        list.removeFront();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void getHead() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(null, list.getHead());

        list.addFront(new Node<>("One").getItem());
        assertEquals(new Node<>("One"), list.getHead());

        list.addBack(new Node<>("Two").getItem());
        assertEquals(new Node<>("One"), list.getHead());

        list.addFront(new Node<>("Zero").getItem());
        assertEquals(new Node<>("Zero"), list.getHead());

        list.removeFront();
        assertEquals(new Node<>("One"), list.getHead());

        list.removeFront();
        assertEquals(new Node<>("Two"), list.getHead());
    }

    @Test
    public void getTail() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(null, list.getTail());

        list.addFront(new Node<>("One").getItem());
        assertEquals(new Node<>("One"), list.getTail());

        list.addBack(new Node<>("Two").getItem());
        assertEquals(new Node<>("Two"), list.getTail());

        list.addFront(new Node<>("Zero").getItem());
        assertEquals(new Node<>("Two"), list.getTail());

        list.removeFront();
        assertEquals(new Node<>("Two"), list.getTail());

        list.addBack("Three");
        assertEquals(new Node<>("Three"), list.getTail());

        list.removeBack();
        assertEquals(new Node<>("Two"), list.getTail());
    }

    @Test
    public void getSize() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.getSize());

        list.addFront(new Node<>("One").getItem());
        assertEquals(1, list.getSize());

        list.addBack(new Node<>("Two").getItem());
        assertEquals(2, list.getSize());

        list.addFront(new Node<>("Zero").getItem());
        assertEquals(3, list.getSize());

        list.removeFront();
        assertEquals(2, list.getSize());

        list.addBack("Three");
        assertEquals(3, list.getSize());

        list.removeBack();
        assertEquals(2, list.getSize());

        list.removeFront();
        list.removeFront();
        assertEquals(0, list.getSize());
    }

    @Test
    public void addFront() throws Exception {
        new LinkedListTest().getHead();
        new LinkedListTest().getTail();
        new LinkedListTest().isEmpty();
        new LinkedListTest().getSize();
    }

    @Test
    public void addBack() throws Exception {
        new LinkedListTest().getHead();
        new LinkedListTest().getTail();
        new LinkedListTest().isEmpty();
        new LinkedListTest().getSize();
    }

    @Test
    public void removeFront() throws Exception {
        new LinkedListTest().getHead();
        new LinkedListTest().getTail();
        new LinkedListTest().isEmpty();
        new LinkedListTest().getSize();
    }

    @Test
    public void removeBack() throws Exception {
        new LinkedListTest().getHead();
        new LinkedListTest().getTail();
        new LinkedListTest().isEmpty();
        new LinkedListTest().getSize();
    }

}