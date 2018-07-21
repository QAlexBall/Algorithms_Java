package LeetCode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp_len = len1;
            len1 = len2;
            len2 = temp_len;
        }



        return 0;
    }
}
