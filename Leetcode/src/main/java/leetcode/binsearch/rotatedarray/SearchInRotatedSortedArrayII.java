package leetcode.binsearch.rotatedarray;

class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] <= nums[right-1]) {
                // 右边有序
                if (nums[mid] == nums[right-1]) {
                    right--;
                    continue;
                }

                if (nums[mid] < target && nums[right-1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 左边有序
                if (nums[mid] == nums[left]) {
                    left++;
                    continue;
                }

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        new SearchInRotatedSortedArrayII().search(new int[]{1, 1, 3, 1}, 3);
    }
}
