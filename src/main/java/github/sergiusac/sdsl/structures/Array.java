package github.sergiusac.sdsl.structures;

import github.sergiusac.sdsl.interfaces.IArray;

import java.util.Iterator;

/**
 * Created by Sergey Cheen on 9/10/17.
 */
public class Array<T> implements Iterable<T>, IArray<T> {

    private T[] items;
    private int count;
    private int capacity;

    public Array() {
        items = (T[]) new Object[10];
        count = 0;
        capacity = 10;
    }

    public Array(int size) {
        items = (T[]) new Object[size];
        count = 0;
        capacity = size;
    }

    public Array(int size, T item) {
        items = (T[]) new Object[size];
        for (int i = 0; i < size; i++)
            items[i] = item;
        count = size;
        capacity = size;
    }

    public Array(T[] arr) {
        items = arr;
        count = arr.length;
        capacity = arr.length;
    }

    public Array(Array<T> otherArray) {
        items = (T[]) new Object[otherArray.capacity];
        for (int i = 0; i < otherArray.count; i++)
            items[i] = otherArray.items[i];
        count = otherArray.count;
        capacity = otherArray.capacity;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public T get(int id) {
        if (id < count) {
            return items[id];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void set(int id, T item) {
        if (id < count) {
            items[id] = item;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void add(T item) {
        if (count == capacity) {
            resize((int) (capacity * 1.5));
            items[count++] = item;
            return;
        }
        items[count++] = item;
    }

    @Override
    public T delete() {
        T item = items[count - 1];
        items[--count] = null;
        return item;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < (newSize > capacity ? capacity : newSize); i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        int id = 0;

        @Override
        public boolean hasNext() {
            return id != count;
        }

        @Override
        public T next() {
            T item = items[id];
            id++;
            return item;
        }
    }
}
