package LeetCode;

public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        boolean isPostive = true;
        if(dividend > 0 ^ divisor > 0) isPostive = false;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs(divisor);

        long res = ldivide(ldividend, ldivisor);
        if(res > Integer.MAX_VALUE) {
            return isPostive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(isPostive ? res : -res);
    }
    public long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor) return 0;
        long res = 1;
        long sum = ldivisor;
        while(ldividend >= (sum + sum)) {
            sum += sum;
            res += res;
        }
        return res + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        Divide_Two_Integers dti = new Divide_Two_Integers();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(dti.divide(dividend, divisor));
    }
}
