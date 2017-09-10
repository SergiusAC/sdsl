package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IArray;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/10/17.
 */
public class Array<T> implements Iterable<T>, IArray<T> {

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int id) {
        return null;
    }

    @Override
    public void set(int id, T item) {

    }

    @Override
    public void add(T item) {

    }

    @Override
    public T delete() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
