package leetcode.medium;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1){
            return  nums[0];
        }
        int start = 0 ;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            // 防止溢出
            int mid =start + (end-start)/2;
            //左边有序 小 - 大
            if(nums[mid]>nums[end]){
                min = nums[start] < min ? nums[start] : min;
                start = mid + 1;
            }else {
            //右边有序 小 - 大
                min = nums[mid] < min ? nums[mid] : min;
                end = mid -1;
            }

        }
        return min;


    }

}
