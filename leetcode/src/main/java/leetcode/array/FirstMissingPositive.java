package leetcode.array;

public class FirstMissingPositive {

    /**
     * 找到第一个丢失的正数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return  n+1;

    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
