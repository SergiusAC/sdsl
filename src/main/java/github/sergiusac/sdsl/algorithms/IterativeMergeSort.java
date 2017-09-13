package github.sergiusac.sdsl.algorithms;

import github.sergiusac.sdsl.structures.Queue;

/**
 * Created by Sergey Cheen on 9/13/17.
 */
public class IterativeMergeSort {

    public static void sort(Comparable[] arr) {
        Queue<Comparable[]> queue = new Queue<>();
        if (arr.length < 1)
            return;
        for (Comparable item : arr) {
            queue.enqueue(new Comparable[] { item });
        }
        while (queue.getSize() > 1) {
            queue.enqueue(merge(queue.dequeue(), queue.dequeue()));
        }
        int i = 0;
        for (Comparable comparable : queue.dequeue()) {
            arr[i] = comparable;
            i++;
        }
    }

    private static Comparable[] merge(Comparable[] a, Comparable[] b) {
        Comparable[] aux = new Comparable[a.length + b.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < aux.length; k++) {
            if (i >= a.length)
                aux[k] = b[j++];
            else if (j >= b.length)
                aux[k] = a[i++];
            else if (Utilities.less(b[j], a[i]))
                aux[k] = b[j++];
            else
                aux[k] = a[i++];
        }
        return aux;
    }
}
