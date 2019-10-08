package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                arr.add(nums[i]);
            }
        }
        return arr;

    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
