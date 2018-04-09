package chapter03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SearchExample {
    public static void main(String[] args) {
        // 重定向标准输入
        try {
            FileInputStream input = new FileInputStream("src/chapter03/a.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ST<String, Integer> st;
        st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            char key = StdIn.readChar();
            st.put(String.valueOf(key), i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
