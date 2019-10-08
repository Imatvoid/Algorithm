package leetcode.dp;

import java.util.Arrays;

/**
 * @Author: yangxu
 * @Date: 2019/8/2 下午10:30
 */
public class HouseRobberII {

    public int robNoCircle(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];


        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] nums1 = new int[nums.length - 1];
        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        int a = robNoCircle(nums1);
        System.arraycopy(nums, 1, nums1, 0, nums.length - 1);
        int b = robNoCircle(nums1);
        return Math.max(a, b);

    }


    public static void main(String[] args) {
        new HouseRobberII().rob(new int[]{2, 1, 1, 2});
    }
}
