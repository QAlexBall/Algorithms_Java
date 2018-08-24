package LeetCode;

public class Find_Pivot_Index {

    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @param nums;
     * @return pivot index  or -1;
     */
    private static int pivotIndex(int[] nums) {
        int sum = 0;
        int before = 0;
        int after;
        for (int num : nums) {
            sum += num;
        }
        if(nums.length == 0) return -1;
        if(sum - nums[0] == 0) return 0;
        for(int i = 0; i < nums.length; i++) {
            before +=  nums[i];
            if(i + 1 == nums.length) break;
            after = sum - before - nums[i + 1];
            if(before == after) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 0};
        System.out.println(pivotIndex(arr));
    }
}
