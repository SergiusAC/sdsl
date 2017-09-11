package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public class ArrayTest {
    @Test
    public void test() throws Exception {
        IArray<String> arr = new Array<>();
        arr.add("q");
        arr.add("w");
        arr.add("e");
        arr.add("r");
        arr.add("t");
        assertEquals("q", arr.get(0));
        assertEquals("w", arr.get(1));
        assertEquals("e", arr.get(2));
        assertEquals("r", arr.get(3));
        assertEquals("t", arr.get(4));

        try {
            arr.get(5);
        } catch(ArrayIndexOutOfBoundsException e) {
            // OK
        }

        arr.set(0, "Q");
        assertEquals("Q", arr.get(0));

        for (String s : arr) {

        }
    }
}