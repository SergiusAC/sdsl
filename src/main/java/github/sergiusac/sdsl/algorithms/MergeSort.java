package github.sergiusac.sdsl.algorithms;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > hi)
                arr[k] = aux[i++];
            else if (Utilities.less(arr[j], arr[i]))
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
    }
}
