package leetcode.array.easy;

public class MoveZeroes {
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    /**
     * 插入元素
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }


    public void moveZeroes2(int[] nums) {


        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zip(nums, i);
                len--;
                i--;
            }

        }


    }

    public void zip(int[] nums, int index) {
        int temp = index;
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = 0;

    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
