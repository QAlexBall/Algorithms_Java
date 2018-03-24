package chapter01;
import java.util.Arrays;

public class Array_Deal {
    private static double max(double[] a) {
        double max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max) max = a[i];
        return max;
    }
    private static double avg(double[] a) {
        int N = a.length;
        double sum = 0.0;
        for (double i : a) sum += i;
        return sum / N;
    }

    private static double[] copy(double[] a) {
        int N = a.length;
        double[] b = new double[N];
//        for (int i = 0; i < N; i++)
//            b[i] = a[i];
        System.arraycopy(a, 0, b, 0, N);
        return b;
    }
    private static double[] reverse(double[] a) {
        int N = a.length;
        for (int i = 0; i < N/2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }
        return a;
    }
    private static double[][] maxtrix_multi(double[][] a, double[][] b){
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    c[i][j] = a[i][k] * b[k][j];
            }
        }
        return c;
    }
    public static void main(String [] args) {
        double[] a = {9, 2, 1, 8};
        double[][] a1 = {{1, 3}, {2,5}};
        double[][] b1 = {{2, 3}, {5, 6}};
        double[][] c1;
        System.out.println(max(a));
        System.out.println(avg(a));
        System.out.println(Arrays.toString(copy(a)));
        System.out.println(Arrays.toString(reverse(a)));
        c1 = (maxtrix_multi(a1, b1));
        System.out.println(c1[0][0]);
    }
}
