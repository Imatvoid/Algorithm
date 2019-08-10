package leetcode.greedy;

/**
 * @Author: yangxu
 * @Date: 19-7-26 上午7:32
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;

        int limit = 0, max = 0, res = 0, cur = 0;
        while (max < n - 1) {
            res++;
            limit = max;
            for (; cur <= limit; cur++) {
                max = Math.max(max, cur + nums[cur]);
            }
            if (limit == max) return -1;
        }
        return res;

    }

    public int jump2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 0;

        int max = 0;
        int count = 0;
        int cur = 0;
        boolean res = false;
        while (true) {
            count++;
            int limit = max;
            for (; cur <= limit; cur++) {
                max = Math.max(nums[cur] + cur, max);
            }
            if (max >= nums.length - 1) {
                res = true;
                break;
            }
            if (limit == max) break;
        }
        return res ? count : 0;
    }
}
