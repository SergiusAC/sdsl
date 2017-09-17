package github.sergiusac.sdsl.interfaces;

/**
 * Created by Sergey Cheen on 9/17/17.
 */
@FunctionalInterface
public interface Order<T> {
    boolean less(T a, T b);
}
