package leetcode.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        fullArray(nums, 0, nums.length - 1);
        return  res;
    }


    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            //System.out.println(Arrays.toString(array));
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++) {
                l.add(array[i]);
            }
            res.add(l);
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                // 恢复
                swap(array, cursor, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private  boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new PermutationsII().permuteUnique(new int[]{1,1,1,2,3,4});
        System.out.println(res.size());
        res.clear();
    }

}
