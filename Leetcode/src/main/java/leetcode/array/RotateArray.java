package leetcode.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        // 可能的测试用例 【1 2】 3  将最后1个元素移动到前面
        k %= nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * 翻转数组
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * 多用空间
     * @param nums
     * @param k
     */
    public void rotateExtraPlace(int[] nums, int k) {

        k = k%nums.length;
        int len = nums.length;

        if (len > 1 && k > 0) {

            int[] arr = new int[len];
            for (int i =0; i< len; ++i)
                arr[(i + k) % len] = nums[i];

            for (int i =0; i< len; ++i)
                nums[i] = arr[i];

        }
    }
}
