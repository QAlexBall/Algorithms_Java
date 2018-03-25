package chapter02;

import edu.princeton.cs.algs4.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TopM {
    public static void main(String[] args) throws FileNotFoundException {
        int M = Integer.parseInt(args[0]);

        // 重定向标准输入
        try {
            FileInputStream input = new FileInputStream("src/chapter02/tinyBatch.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }
}
