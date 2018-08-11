package LeetCode;

import java.util.HashMap;

public class Longest_Palindromic_Subsequence {
    public int longestPalindromicSubseq(String s) {
        int s_len = s.length();
        int tmp;
        int[][] dp = new int[s_len][s_len];
        for(int i = 0; i < s_len; i++)  dp[i][i] = 1;
        // 求首位相差i的子串的最长子序列
        // i = 1时, [j, j + i] [0, 1] [1, 2] [2, 3] ...
        // i = 2时, [j, j + i] [0, 2] [1, 3] [2, 4] ...
        // [0, 2]的最长子序列为[1, 1] +２或者max([1, 2], [2, 3])
        // 依次类推求出最长回文子序列为dp[0][s_len - 1]
        for(int i = 1; i < s_len; i++) {
            for (int j = 0; j + i < s_len; j++) {
                if (s.charAt(j) == s.charAt(j + i))
                    tmp = dp[j + 1][j + i - 1] + 2;
                else
                    tmp = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                dp[j][j + i] = tmp;
                System.out.println(j + " " + (i + j) + " " + dp[j][i + j]);
            }
            System.out.println();
        }
        return dp[0][s_len - 1];
    }

    public static void main(String[] args) {
        Longest_Palindromic_Subsequence lps = new Longest_Palindromic_Subsequence();
        String s = "adbcba";
        int res = lps.longestPalindromicSubseq(s);
        System.out.println("the result is: " + res);
    }
}
