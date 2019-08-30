package leetcode.PermutationAndCombination;

/**
 * @Author: yangxu
 * @Date: 2019/8/28 上午9:05
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        boolean flag = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if(nums[i]>nums[i-1]){
                flag= true;
                for(int j=nums.length-1;j>0;j--){
                    if(nums[j]>nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                }

                reverse(i, nums.length-1,nums);
                break;
            }

        }
        if(!flag){
            reverse(0,nums.length-1,nums);
        }

    }


    public void reverse(int start, int end, int[] nums) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
