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



    public List<List<Integer>> twoSumIndex(int[] nums, int target, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        sorted[index] = Integer.MIN_VALUE;
        Arrays.sort(sorted);

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (sorted[left] + sorted[right] < target) {
                left++;
            } else if (sorted[left] + sorted[right] > target) {
                right--;
            } else {
                break; //found it! sorted[left]+sorted[right]==target
            }
        }

        // not same
        if (left == right) {
            return null;
        }


        List<Integer> leftIndexList = new ArrayList<>();
        List<Integer> rightIndexList = new ArrayList<>();

        //find the index in nums
        for (int i = 0; i < sorted.length; i++) {
            if (nums[i] == sorted[left]) {
                leftIndexList.add(i);
            }
            if (nums[i] == sorted[right]) {
                rightIndexList.add(i);
            }
        }

        for (int i : leftIndexList) {
            for (int j : rightIndexList) {
                if (i != j) {
                    //leetcode.sort the final result
                    Integer[] result = {i, j};
                    Arrays.sort(result);
                    res.add(new ArrayList<Integer>(Arrays.asList(result)));
                }
            }
        }


        return res;

    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
