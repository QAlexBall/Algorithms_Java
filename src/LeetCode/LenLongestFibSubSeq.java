package LeetCode;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LenLongestFibSubSeq {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        int longest = 0;
        int res = 0;
        for(int i = 0; i < len; i++) {          // 将第i个位置的数作为最长子序列的第一个元素
            // System.out.println("A[i] is " + A[i]);
            int begin = A[i];                    // 记为begin
            for(int j = i + 1; j < len; j++) {      // 遍历i之后的元素,并与begin相加
                int temp = j;
                int tempA = begin;
                // System.out.println(A[j]);
                for (int k = j + 1; k < len; k++) { // 查看i位置与j位置相加的元素,是否在j位置之后是否存在
                    // System.out.println("AK is: " +  A[k]);
                    int tempk = k;
                    if (begin + A[j] == A[k]) {  // 如果存在
                        begin = A[j];           // 使将j位置更新为begin
                        j = tempk;                   // 将j位置置为k
                        longest++;              // longest++
                        // System.out.println("begin is: " + begin);
                    }
                }
                begin = tempA;
                if (longest > res) res = longest;
                // System.out.println("longest is: " + longest);
                j = temp;
                longest = 0;
            }
        }
        if(res == 0) return 0;
        return res + 2;
    }// 超出时间限制  时间复杂度O(n^3) 空间复杂度O(1)

    public int lenLongestFibSubseq1(int[] A) {
        int len = A.length;
        int res = 0;

        Set<Integer> s = new HashSet<>();
        for (int x : A) s.add(x);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int longest = 0;
                int x = A[j];
                int y = A[i] + A[j];
                while(s.contains(y)) {
                    int temp = y;
                    y += x;
                    x = temp;
                    res = Math.max(res, ++longest);
                }
            }
        }
        return res >= 1 ? res + 2 : 0;
    }
    public int lenLongestFibSubseq2(int[] A) {
        int len = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < len; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap<>();
        int res = 0;

        for(int k = 0; k < len; ++k) {
            System.out.println("A[K] is: " + A[k]);
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cand = longest.getOrDefault(i * len + j, 2) + 1;
                    // cand = longest.getOrDefault(tuple(i, j), 2) + 1;
                    longest.put(j * len + k, cand);
                    // longest.put(tuple(j, k), cand);
                    System.out.println(i * len + j);
                    System.out.println("i is:" + i + "   j is: " + j + "   k is: " + k +  "   cand is: " + cand);
                    res = Math.max(res, cand);
                }
            }
        }
        System.out.println(longest);
        return res >= 3 ? res : 0;
    }
    public static void main(String[] args) {
        int[] B = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] A = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        LenLongestFibSubSeq llfss = new LenLongestFibSubSeq();
        // System.out.println("the result is: " + llfss.lenLongestFibSubseq2(B));
        System.out.println("the result is: " + llfss.lenLongestFibSubseq2(A));
    }
}
