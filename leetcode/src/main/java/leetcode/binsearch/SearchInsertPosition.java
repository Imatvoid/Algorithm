package leetcode.binsearch;

public class SearchInsertPosition {
    /**
     * 查找第一个不小于目标值的数字
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            // 这里忽略等于情况

            // 这里使用mid 和 target比
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
