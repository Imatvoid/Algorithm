package leetcode.binsearch;

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            //左边有序 小 - 大
            if (nums[mid] > nums[right]) {

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;

    }

    public int search2(int[] nums, int target) {


        int left = 0;
        int right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            //左边有序 小 - 大
            if (nums[mid] > nums[right>=nums.length?nums.length-1:right]) {

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && nums[right>=nums.length?nums.length-1:right] >= target) {
                    left = mid + 1;
                } else {
                    right =mid ;
                }
            }


        }

        return -1;
    }
}
