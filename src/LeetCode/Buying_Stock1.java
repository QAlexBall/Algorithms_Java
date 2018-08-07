package LeetCode;

public class Buying_Stock1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            int tmp = price - min;
            if (min > price) min = price;// 如果价格比前面都便宜则选择当天买入
            if (tmp > max) max = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Buying_Stock1 bs1 = new Buying_Stock1();
        System.out.println(bs1.maxProfit(prices));
    }
}
