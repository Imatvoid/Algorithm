package leetcode.dp;

import java.util.Arrays;


/**
 * 连续上升的三个数字的序列
 */
public class IncreasingTripletSubsequence {

    /** 效率最高的方法 O（N）  O（1）
     * @param nums 输入数组
     * @return
     */
    public boolean increasingTriplet(int[] nums) {

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a <= m1) m1 = a;
            else if (a <= m2) m2 = a;
            else return true;
        }
        return false;
    }


    /**
     * dp 方法 dp[i]代表 小于等于nums[i]的数量
     * @param nums
     * @return
     */
    public boolean increasingTripletDp(int[] nums) {
        if (nums.length < 3) return false;
        int n = nums.length;


        // dp[i]代表 小于等于nums[i]的数量
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) return true;
                }
            }
        }

        return false;
    }

    /**
     * 两个数组
     * @param nums
     * @return
     */
    public boolean increasingTripletEasyUnderstand(int[] nums) {
        if (nums.length < 3) return false;
        int n = nums.length;

        int f[] = new int[n];
        f[0] = nums[0];
        int b[] = new int[n];
        b[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            f[i] = Math.min(f[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            b[i] = Math.max(b[i + 1], nums[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > f[i] && nums[i] < b[i]) return true;
        }
        return false;
    }
}
