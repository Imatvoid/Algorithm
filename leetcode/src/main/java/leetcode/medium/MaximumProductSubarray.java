package leetcode.medium;

public class MaximumProductSubarray {


    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        //return solution1(nums);
        return solution2(nums);

    }

    /**
     * dp 解法
     * @param nums
     * @return
     */
    int solution2(int[] nums) {

        int res = nums[0], n = nums.length;

        int f[] = new int[n];
        int g[] = new int[n];

        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;

    }

    int solution1(int[] nums) {
        Long res = Long.MIN_VALUE;
        Long sum = 1L;

        for (int i = 0; i < nums.length; i++) {
            //sum = Long.valueOf(nums[i]);
            sum = 1L;
            for (int j = i; j < nums.length; j++) {
                sum *= nums[j];
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
