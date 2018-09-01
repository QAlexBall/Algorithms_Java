package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String s, int i, int i1, int n) {
        if(s.length() == n * 2) {
            ans.add(s);
            return;
        }

        if(i < n)
            backtrack(ans, s + "(", i + 1, i1, n);
        if(i1 < i)
            backtrack(ans, s + ")", i, i1 + 1, n);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
