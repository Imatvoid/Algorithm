package leetcode.ksum;

import java.util.*;

public class ThreeSum {


    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            else {
                twoSum(nums, -nums[i], i);
            }
        }

        return res;

    }

    void twoSum(int[] nums, int target, int i) {

        int right = nums.length-1;
        int left =i+1;
        while(left<right){
            if(nums[left]+nums[right]<target){
                left++;
                continue;
            }
            else if(nums[left]+nums[right]>target){
                right--;
                continue;
            }
            else{
                ArrayList<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                t.add(nums[left]);
                t.add(nums[right]);
                res.add(t);
                //处理重复的情况
                left++;
                right--;
                while(left<right && nums[left] == nums[left-1]) left++;
                while(left<right && nums[right] == nums[right+1]) right--;
            }
        }

    }


    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
