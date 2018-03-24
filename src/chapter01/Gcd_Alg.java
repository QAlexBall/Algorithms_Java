package chapter01;

public class Gcd_Alg {
    private static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String [] args) {
        int p = 21;
        int q = 15;
        System.out.println("the result is:" + gcd(p, q));
    }
}
