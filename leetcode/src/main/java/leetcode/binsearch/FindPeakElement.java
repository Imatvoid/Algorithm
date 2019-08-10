package leetcode.binsearch;

public class FindPeakElement {
    /**
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //System.out.println("left:"+left+"right:"+right);
        return left;
    }


    public static void main(String[] args) {
        new FindPeakElement().findPeakElement(new int[]{1,2});
    }
}
