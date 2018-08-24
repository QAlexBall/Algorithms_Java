package LeetCode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // 如果hashmap中存有与complement相等的数
            }                                                 // map.get返回complement的key也就是数组下表，i返回当前元素的数组下标
            map.put(nums[i], i);                             // 将数组当前值与其下标存入hashmap
        }
        throw new IllegalArgumentException("No two solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 13};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

}
