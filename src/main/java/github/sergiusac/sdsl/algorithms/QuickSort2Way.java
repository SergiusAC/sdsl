package github.sergiusac.sdsl.algorithms;

/**
 * Created by Sergey Cheen on 9/14/17.
 */
public class QuickSort2Way {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        while (lo < hi) {
            int mid = partition(arr, lo, hi);
            sort(arr, lo, mid - 1);
            lo = mid + 1;
        }
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        Comparable x = arr[lo];
        int j = lo;
        for (int k = lo + 1; k <= hi; k++)
            if (Utilities.less(arr[k], x))
                Utilities.exchange(arr, ++j, k);
        Utilities.exchange(arr, lo, j);
        return j;
    }
}
