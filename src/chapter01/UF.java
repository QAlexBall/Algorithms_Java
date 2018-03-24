package chapter01;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UF {
    private int[] id;
    private int count;
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return quick_find(p) == quick_find(q);
    }
    public int quick_find(int p) {
        return id[p];
    }
    public void quick_find_union(int p, int q) {
        int pID = quick_find(p);
        int qID = quick_find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public boolean connected_quick_union(int p, int q) {
        return quick_union_find(p) == quick_union_find(q);
    }
    public int quick_union_find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    public void quick_union(int p, int q) {
        int pRoot = quick_union_find(p);
        int qRoot = quick_union_find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src//chapter01//tinyUF.txt");
        Scanner scanner = new Scanner(fr);
        int N = scanner.nextInt();
        UF uf = new UF(N);

        // Quick_Find
//        while (scanner.hasNext()) {
//            int p = scanner.nextInt();
//            int q = scanner.nextInt();
//            if (uf.connected(p, q)) continue;
//            uf.quick_find_union(p, q);
//            System.out.println(p + " " + q);
//        }
//        System.out.println(uf.count() + "components");
//        FileReader fr1 = new FileReader("src//chapter01//tinyUF.txt");
//        Scanner scanner1 = new Scanner(fr1);

        // Quick_Union
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected_quick_union(p, q)) continue;
            uf.quick_union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.print(uf.count() + " components");
    }
}
