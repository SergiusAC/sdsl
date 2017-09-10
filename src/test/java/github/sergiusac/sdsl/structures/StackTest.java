package github.sergiusac.sdsl.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/10/17.
 */
public class StackTest {
    @Test
    public void test() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.push("Five");

        String[] words = new String[5];
        for (int i = 0; i < 5; i++) {
            words[i] = stack.peek();
        }
        assertArrayEquals(new String[] {"Five", "Five", "Five", "Five", "Five"}, words);
        assertEquals(5, stack.getSize());
        assertEquals(false, stack.isEmpty());

        for (int i = 0; i < 5; i++) {
            words[i] = stack.pop();
        }
        assertArrayEquals(new String[] {"Five", "Four", "Three", "Two", "One"}, words);
        assertEquals(0, stack.getSize());
        assertEquals(true, stack.isEmpty());

        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        words = new String[3];
        int i = 0;
        for (String s : stack) {
            words[i] = s;
            i++;
        }
        assertArrayEquals(new String[] {"Three", "Two", "One"}, words);
    }
}