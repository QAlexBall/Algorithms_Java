package chapter01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WeightQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(q) == find(q);
    }
    public int find(int p) {
        // 跟随链接找到根节点
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j; sz[j] += sz[i];
        }
        else {
            id[j] = i; sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader("src//chapter01/tinyUF.txt");
        Scanner scanner = new Scanner(fr);
        int N = scanner.nextInt();
        WeightQuickUnionUF uf = new WeightQuickUnionUF(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + "components");
    }
}
