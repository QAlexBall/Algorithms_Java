package LeetCode;

public class Atoi {
    public int myAtoi(String str) {
        int i = 0;
        int res = 0;
        int sign = 0;
        int sign1 = 0;
        int digit_count = 0;
        System.out.println("the string length is:" + str.length());

        while (i < str.length()) {
            char str_i = str.charAt(i);
            if((digit_count + sign != 0 && !Character.isDigit(str_i)) || (digit_count + sign1 != 0 && !Character.isDigit(str_i))) {
                if(sign > 0) {
                    return 0 - res;
                } else {
                    return res;
                }
            }
            if(str_i == ' ') {
                i++;
                continue;
            }
            if(str_i == '-') {
                sign++;
                i++;
                continue;
            }
            if(str_i == '+') {
                i++;
                sign1++;
                continue;
            }
            if(sign1 + sign > 1) {
                return 0;
            }
            if(!Character.isDigit(str_i)) {
                return 0;
            }
            int digit = str_i - 48;
            if ((res > Integer.MAX_VALUE/10 && sign == 0) || ((res == Integer.MAX_VALUE / 10 && digit > 7 && sign == 0))) return Integer.MAX_VALUE;
            if ((res > Integer.MAX_VALUE/10 && sign > 0) || ((res == Integer.MAX_VALUE / 10 && digit > 8 && sign > 0))) return Integer.MIN_VALUE;
            res = res * 10 + digit;
            System.out.println(str_i + " " + res);
            i++;
            digit_count ++;
        }
        if(sign > 0) {
            return 0 - res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "   02";
        Atoi atoi = new Atoi();
        System.out.println("the result is:" + atoi.myAtoi(s));
    }
}
