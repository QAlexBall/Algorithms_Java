package LeetCode;

// 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
// 如果没有两个连续的 1，返回 0 。
public class Binary_Gap {
    public static int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)    // 寻找下一个为1的位置
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;               //  使last等于当前1的位置
            }
        return ans;
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println("result is: " + binaryGap(N));
    }
}
