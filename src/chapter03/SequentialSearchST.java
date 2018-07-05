package chapter03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定的键， 返回相关联的值
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        // 查找给定的键，找到则更新其值，否则在表中新建结点
        for(Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }                                   // 命中， 更新
        first = new Node(key, val, first);  // 未命中，新建结点
    }

    public Iterable<Key> keys(Key lo, Key hi) {    // [lo..hi]之间的所有键，已排序
        return null;
    }
    public Iterable<Key> keys() {     // 表中的所有键的集合，已排序
        return null;
    }
    public static void main(String [] args) {
        try {
            FileInputStream input = new FileInputStream("src/chapter03/tinyTale.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SequentialSearchST<String, Integer> st;
        st = new SequentialSearchST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            char key = StdIn.readChar();
            st.put(String.valueOf(key), i);
        }
        System.out.println(st.get("e"));
    }
}
