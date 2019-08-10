package leetcode.binsearch;

class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] <= nums[right]) {
                // 右边有序
                if(nums[mid] == nums[right]){
                    right--;
                    continue;
                }

                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左边有序
                if(nums[mid] == nums[left]){
                    left++;
                    continue;
                }


                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
         new SearchInRotatedSortedArrayII().search(new int[]{1,1,3,1},3);
    }
}
