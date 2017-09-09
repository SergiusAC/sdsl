package github.sergiusac.sdsl.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/9/17.
 */
public class NodeTest {
    @Test
    public void getItem() throws Exception {
        Node<String> stringNode = new Node<>("frontback", null, null);
        assertEquals("frontback", stringNode.getItem());
        stringNode.setItem(null);
        assertEquals(null, stringNode.getItem());
    }

    @Test
    public void setItem() throws Exception {
        Node<String> stringNode = new Node<>();
        stringNode.setItem("frontback");
        assertEquals("frontback", stringNode.getItem());
        stringNode.setItem(null);
        assertEquals(null, stringNode.getItem());
    }

    @Test
    public void getNext() throws Exception {
        Node<Integer> nextNode = new Node<>(15, null, null);
        Node<Integer> intNode = new Node<>(25, nextNode, null);
        assertEquals(nextNode, intNode.getNext());
        Node<Integer> newNextNode = new Node<>(22, null, null);
        intNode.setNext(newNextNode);
        assertEquals(newNextNode, intNode.getNext());
    }

    @Test
    public void setNext() throws Exception {
        Node<Integer> nextNode = new Node<>(15, null, null);
        Node<Integer> intNode = new Node<>(25, null, null);
        intNode.setNext(nextNode);
        assertEquals(nextNode, intNode.getNext());
        Node<Integer> newNextNode = new Node<>(22, null, null);
        intNode.setNext(newNextNode);
        assertEquals(newNextNode, intNode.getNext());
    }

    @Test
    public void getPrev() throws Exception {
        Node<Integer> prevNode = new Node<>(15, null, null);
        Node<Integer> intNode = new Node<>(25, null, prevNode);
        assertEquals(prevNode, intNode.getPrev());
        Node<Integer> newPrevNode = new Node<>(22, null, null);
        intNode.setPrev(newPrevNode);
        assertEquals(newPrevNode, intNode.getPrev());
    }

    @Test
    public void setPrev() throws Exception {
        Node<Integer> prevNode = new Node<>(15, null, null);
        Node<Integer> intNode = new Node<>(25, null, null);
        intNode.setPrev(prevNode);
        assertEquals(prevNode, intNode.getPrev());
        Node<Integer> newPrevNode = new Node<>(22, null, null);
        intNode.setPrev(newPrevNode);
        assertEquals(newPrevNode, intNode.getPrev());
    }

}