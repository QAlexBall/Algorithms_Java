package chapter03;

/*
  基于有序数组
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


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

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

//    public Iterable<Key> keys(Key lo, Key hi) {
//        Queue<Key> q = new Queue<Key>();
//        for (int i = rank(lo); i < rank(hi); i++)
//            q.enqueue(keys[i]);
//        if (contains(hi))
//            q.enqueue(keys[rank(hi)]);
//        return q;
//    }
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key) { // 基于有序数组的二分查找
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else return mid;
        }
        return lo;
    }

    public int rank(Key key, int lo, int hi) { // 递归的二分查找
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
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

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key) {

    }

    public static void main(String [] args) {
        try {
            FileInputStream input = new FileInputStream("src/chapter03/a.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int capacity = 20;
        BinarySearchST<String, Integer> st = new BinarySearchST<>(capacity);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            char key = StdIn.readChar();
            st.put(String.valueOf(key), i);
        }
        System.out.println(st.get("A"));
    }
}
