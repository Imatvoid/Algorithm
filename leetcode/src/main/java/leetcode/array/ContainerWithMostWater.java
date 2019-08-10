package leetcode.array;

/**
 * @Author: yangxu
 * @Date: 2019/8/10 下午2:26
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return  max;
    }
}
