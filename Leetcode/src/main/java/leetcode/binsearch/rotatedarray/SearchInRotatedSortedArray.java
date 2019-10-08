package leetcode.binsearch.rotatedarray;

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            //左边有序 小 - 大
            if (nums[mid] > nums[right-1]) {
                // find
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    //not
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && nums[right-1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return -1;
    }
}
