package github.sergiusac.sdsl.algorithms;

import github.sergiusac.sdsl.interfaces.Order;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public class Utilities {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean less(Comparable a, Comparable b, Order order) {
        return order.less(a, b);
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (less(arr[i], arr[i - 1]))
                return false;
        return true;
    }
}
