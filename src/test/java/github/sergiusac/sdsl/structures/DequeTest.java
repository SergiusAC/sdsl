package github.sergiusac.sdsl.structures;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/10/17.
 */
public class DequeTest {
    @Test
    public void test() throws Exception {
        Deque<String> d = new Deque<>();
        String[] ta = new String[2];

        d.pushFront("B");
        d.pushFront("A");
        d.pushBack("C");
        ta[0] = d.peekFront();
        ta[1] = d.peekBack();
        assertArrayEquals(new String[] {"A", "C"}, ta);
        assertEquals(3, d.getSize());
        assertEquals(false, d.isEmpty());

        ///////////////////////////////////////////

        d = new Deque<>();
        d.pushBack("A");
        d.pushBack("B");
        d.pushBack("C");
        ta = new String[3];
        for (int i = 0; i < 3; i++) {
            ta[i] = d.popBack();
        }
        assertArrayEquals(new String[] {"C", "B", "A"}, ta);
        assertEquals(0, d.getSize());
        assertEquals(true, d.isEmpty());

        ///////////////////////////////////////////

        d.pushBack("A");
        d.pushBack("B");
        d.pushBack("C");
        ta = new String[3];
        for (int i = 0; i < 3; i++) {
            ta[i] = d.peekFront();
        }
        assertArrayEquals(new String[] {"A", "A", "A"}, ta);
        for (int i = 0; i < 3; i++) {
            ta[i] = d.popFront();
        }
        assertArrayEquals(new String[] {"A", "B", "C"}, ta);
        assertEquals(0, d.getSize());
        assertEquals(true, d.isEmpty());

        ///////////////////////////////////////////

        d.pushFront("A");
        d.pushFront("B");
        d.pushFront("C");
        ta = new String[3];
        for (int i = 0; i < 2; i++) {
            ta[i] = d.peekBack();
        }
        ta[2] = d.peekFront();
        assertArrayEquals(new String[] {"A", "A", "C"}, ta);
        for (int i = 0; i < 3; i++) {
            ta[i] = d.popBack();
        }
        assertArrayEquals(new String[] {"A", "B", "C"}, ta);
        assertEquals(0, d.getSize());
        assertEquals(true, d.isEmpty());

        ////////////////////////////////////////////

        d.pushFront("B");
        d.pushBack("C");
        d.pushFront("A");
        ta = new String[3];
        int i = 0;
        for (String s : d) {
            ta[i] = s;
            i++;
        }
        assertArrayEquals(new String[] {"A", "B", "C"}, ta);
        d.popBack();
        d.popBack();
        d.popBack();
        d.pushFront("B");
        d.pushBack("C");
        d.pushFront("A");
        i = 0;
        Iterator<String> it = d.descendingIterator();
        while (it.hasNext()) {
            ta[i] = it.next();
            i++;
        }
        assertArrayEquals(new String[] {"C", "B", "A"}, ta);
    }
}