package leetcode.binsearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length== 1) return 0;
        int n = nums.length;
        int lo = 0, hi = n - 2;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < nums[mid+1]) {
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }

    //  public int findPeakElement(int[] nums) {
    //     int left = 0, right = nums.length - 1;
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         if (nums[mid] < nums[mid + 1]) left = mid + 1;
    //         else right = mid;
    //     }
    //     return right;
    // }

    public static void main(String[] args) {
        new FindPeakElement().findPeakElement(new int[]{1,2});
    }
}
