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

    public int rank(Key key) { // 基于有序数组的二分查找
        int lo = 0;
        int hi = N -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) { hi = mid - 1; }
            else if (cmp > 0) { lo = mid + 1; }
            else return mid;
        }
        return lo;
    }

    public int rank(Key key, int lo, int hi) { // 递归的二分查找
        if(hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if      (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }
    public void put(Key key, Value val) {
        // 查找键，找到则更新新值，否则创建新的元素
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for(int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            keys[i] = key;
            vals[i] = val;
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }


}
