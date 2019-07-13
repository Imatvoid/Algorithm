package leetcode.bitmanipulation;

public class MissingNumber {

    /**
     * 缺的是0没关系，本来就是0
     *
     * 从1-n 异或这个数组
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int res =0;
        for(int i=0;i<nums.length;i++){
            res ^= (i+1)^nums[i];
        }
        return res;

    }
}
