package leetcode.binsearch.rotatedarray;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1){
            return  nums[0];
        }
        int left = 0 ;
        int right = nums.length;
        int min = Integer.MAX_VALUE;
        while(left<right){
            // 防止溢出
            int mid =left + (right-left)/2;
            //左边有序 小 - 大
            if(nums[mid] < nums[right-1]){
                min = nums[left] < min ? nums[left] : min;
                left = mid + 1;
            }else {
                //右边有序 小 - 大
                min = nums[mid] < min ? nums[mid] : min;
                right = mid;
            }

        }
        return min;
    }

}
