package leetcode.bitmanipulation;

public class MissingNumber {

    /**
     * 缺的是0没关系，本来就是0
     * <p>
     * 从1-n 异或这个数组
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;

    }

    /**
     * 放回原位
     * @param nums 0-n-1 放 0-n-1
     * @return
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= n - 1 && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
                // 这里很重要
                i--;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
