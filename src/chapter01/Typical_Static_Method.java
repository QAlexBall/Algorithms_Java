package chapter01;
public class Typical_Static_Method {
    public static int abs(int x) {
        if ( x == -1) return 100;
        if (x < 0) return -x;
        else return x;
    }

    public static double abs(double x) {
        if (x < 0.0) return -x;
        else return x;
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Typical_Static_Method tsm = new Typical_Static_Method();
        System.out.println(abs(-1));
    }
}
