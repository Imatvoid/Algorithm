package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangxu
 * @Date: 2019/8/10 下午3:19
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                i--;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                list.add(i+1);
            }
        }
        return list;
    }

    void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
