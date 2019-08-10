package leetcode.binsearch;

public class BinSearch {

    int findFirstEQ(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        System.out.println("left:"+left+",right:"+right);
        return left;
    }

    /**
     * 找第一个大于
     *
     * @param nums
     * @param target
     * @return
     */
    int findFirstGT(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        System.out.println("left:"+left+",right:"+right);
        return left;
    }

    /**
     * 找第一个不大于
     *
     * @param nums
     * @param target
     * @return
     */
    int findFirstNGT(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        System.out.println("left:"+left+",right:"+right);
        return left-1;
    }



    /**
     * 找第一个不小于
     *
     * @param nums
     * @param target
     * @return
     */
    int findFirstNLT(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        System.out.println("left:"+left+",right:"+right);
        return left;
    }


    /**
     * 找第一个小于
     *
     * @param nums
     * @param target
     * @return
     */
    int findFirstLT(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        System.out.println("left:"+left+",right:"+right);
        return left-1;
    }


    public static void main(String[] args) {
        System.out.println(new BinSearch().findFirstGT(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinSearch().findFirstGT(new int[]{1, 2, 3, 4}, 3));

        System.out.println(new BinSearch().findFirstNGT(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinSearch().findFirstNGT(new int[]{1, 2, 3, 4}, 3));


        System.out.println(new BinSearch().findFirstNLT(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinSearch().findFirstNLT(new int[]{1, 2, 3, 4}, 3));


        System.out.println(new BinSearch().findFirstLT(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinSearch().findFirstLT(new int[]{1, 2, 3, 4}, 3));
    }
}
