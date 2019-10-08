package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

class MajorityElementII {


    public List<Integer> majorityElement(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();

        int n1 = -12321321;
        int n2 = 23432432;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == n1) {
                count1++;
            } else if (nums[i] == n2) {
                count2++;
            } else if (count1 == 0) {
                n1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                n2 = nums[i];
                count2 = 1;
            } else if (nums[i] != n1 && nums[i] != n2) {
                count1--;
                count2--;
            }

        }
        if (count1 != 0 && validateME(nums, n1)) {
            res.add(n1);
        }
        if (count2 != 0 && validateME(nums, n2)) {
            res.add(n2);
        }
        return res;


    }


    boolean validateME(int[] nums, int val) {
        int count = 0;
        for (int n : nums) {
            if (n == val) {
                count++;
            }
        }
        if (count > nums.length / 3) {
            return true;
        } else {
            return false;
        }
    }


}
