package github.sergiusac.sdsl.algorithms;

import github.sergiusac.sdsl.interfaces.Order;

/**
 * Created by Sergey Cheen on 9/11/17.
 */
public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1, null);
    }

    public static void sort(Comparable[] arr, Order<?> order) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1, order);
    }

    private static void sort(Comparable[] arr, int lo, int hi,
                             Order order) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid, order);
            sort(arr, mid + 1, hi, order);
            merge(arr, lo, mid, hi, order);
        }
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi,
                              Order order) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > hi)
                arr[k] = aux[i++];
            else if (order == null ?
                    Utilities.less(aux[j], aux[i]) :
                    Utilities.less(aux[j], aux[i], order))
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
    }
}
