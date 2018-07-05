package chapter03;
/**
 * 基于有序数组
 */

import static edu.princeton.cs.algs4.BinaryStdIn.isEmpty;

public class BinarySearchST<Key extends  Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }
    public int rank(Key key) {
        return 0;
    }

    public void put(Key key, Value val) {
        int i = 0;
        for(int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            keys[i] = key;
            vals[i] = val;
        }
    }
}
