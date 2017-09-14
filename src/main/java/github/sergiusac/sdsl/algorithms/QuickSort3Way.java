package github.sergiusac.sdsl.algorithms;

/**
 * Created by Sergey Cheen on 9/14/17.
 */
public class QuickSort3Way {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        while (lo < hi) {
            int lt = lo, i = lo + 1, gt = hi;
            Comparable v = arr[lo];
            while (i <= gt) {
                int cmp = arr[i].compareTo(v);
                if (cmp < 0)
                    Utilities.exchange(arr, lt++, i++);
                else if (cmp > 0)
                    Utilities.exchange(arr, i, gt--);
                else
                    i++;
            }
            sort(arr, lo, lt-1);
            lo = gt + 1;
        }
    }
}
