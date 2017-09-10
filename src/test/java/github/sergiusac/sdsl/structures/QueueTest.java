package github.sergiusac.sdsl.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/10/17.
 */
public class QueueTest {
    @Test
    public void test() throws Exception {
        Queue<String> q = new Queue<>();
        q.enqueue("I");
        q.enqueue("am");
        q.enqueue("human");

        String[] words = new String[2];
        for (int i = 0; i < 2; i++) {
            words[i] = q.peek();
        }
        assertArrayEquals(new String[] {"I", "I"}, words);
        assertEquals(3, q.getSize());
        assertEquals(false, q.isEmpty());

        q.dequeue();
        assertEquals(2, q.getSize());
        for (int i = 0; i < 2; i++) {
            words[i] = q.peek();
        }
        assertArrayEquals(new String[] {"am", "am"}, words);

        q.enqueue("yeah");
        words = new String[3];
        int i = 0;
        for (String s : q) {
            words[i] = s;
            i++;
        }
        assertArrayEquals(new String[] {"am", "human", "yeah"}, words);
        for (int j = 0; j < 3; j++) {
            words[j] = q.dequeue();
        }
        assertArrayEquals(new String[] {"am", "human", "yeah"}, words);
        assertEquals(0, q.getSize());
        assertEquals(true, q.isEmpty());
    }
}