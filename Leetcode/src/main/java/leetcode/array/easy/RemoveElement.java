package leetcode.array.easy;

/**
 * @Author: yangxu
 * @Date: 2019/8/26 下午11:27
 */
public class RemoveElement {
    /**
     * 重插入的方式
     * @param nums
     * @param elem
     * @return
     */
    public int removeElement(int[] nums, int elem) {
        if (nums == null || nums.length == 0) return 0;

        int insertPos = 0;
        for (int num : nums) {
            if (num != elem) nums[insertPos++] = num;
        }

        // while (insertPos < nums.length) {
        //     nums[insertPos++] = 0;
        // }
        return insertPos;
    }

    public int removeElement2(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            while (A[i] == elem && i < len) {
                A[i] = A[--len];
            }
        }
        return len;
    }
}
