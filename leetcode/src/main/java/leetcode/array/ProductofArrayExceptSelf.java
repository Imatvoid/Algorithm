package leetcode.array;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    /**
     *非空间最优
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int before[] = new int[n];
        int after[] = new int[n];
        Arrays.fill(before, 1);
        Arrays.fill(after, 1);
        for (int i = 0; i < n - 1; i++) {
            before[i + 1] = before[i] * nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            after[i - 1] = after[i] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = before[i] * after[i];
        }
        return nums;

    }

    /**
     * 使用，减少一遍遍历、节约空间
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int before[] = new int[n];

        Arrays.fill(before, 1);

        for (int i = 1; i < n ; i++) {
            before[i] = before[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = n-2; i >=0; i--) {
            right *= nums[i+1];
            before[i] = before[i] * right;
        }
        return before;

    }

}
