package leetcode.binsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<Integer>();
        Integer [] res= new Integer[n];
        for (int i = nums.length- 1; i >= 0; --i) {
            int left = 0, right = t.size()-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (t.get(mid) < nums[i] ) left = mid+1;
                else right = mid - 1;
            }
            // 实际的位置应该加1
            res[i] = right+1;
            t.add(right+1, nums[i]);
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }


    public static void main(String[] args) {

        new CountofSmallerNumbersAfterSelf().countSmaller(new int[]{5, 2, 6, 1});
    }
}
