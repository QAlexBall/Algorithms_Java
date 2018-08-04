package LeetCode;

public class Container_With_Most_Water {
    public  int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxarea = 0;
        while(end - start != 0) {
            maxarea = Math.max(maxarea, Math.min(height[start], height[end]) * (end - start));
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxarea;
    }

    public static void main(String [] args) {
        int[] height = {1, 8, 6, 3, 5, 4, 8 ,3, 7};
        Container_With_Most_Water cwmw = new Container_With_Most_Water();
        System.out.println(cwmw.maxArea(height));
    }
}
