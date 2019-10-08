package leetcode.binsearch.findnlt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<Integer>();
        Integer [] res= new Integer[n];
        for (int i = nums.length- 1; i >= 0; --i) {
            int left = 0, right = t.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (t.get(mid) < nums[i] ) left = mid+1;
                else right = mid;
            }
            // i是应该插入的index,也是比自己小的数的count.
            res[i] = left;
            t.add(left, nums[i]);
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }


    public static void main(String[] args) {

        new CountOfSmallerNumbersAfterSelf().countSmaller(new int[]{5, 2, 6, 1});
    }
// 这种写法 left = right 最后结果.
//     for (int i = nums.length- 1; i >= 0; --i) {
//   1.     int left = 0, right = t.size();
//   2.     while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (t.get(mid) < nums[i] ) left = mid+1;
//   3.         else right = mid;
//        }
//        // i是应该插入的index,也是比自己小的数的count.
//        res[i] = left;
//        t.add(left, nums[i]);
//    }
//  另外一种写法 right = left + 1;
}
