package leetcode.binsearch;

public class FindtheDuplicateNumber {

    /**
     *  第一个大于
     *  nO(logn)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {


        int n = nums.length;
        int left =1,right= n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int count =0;
            for(int i:nums){
                if(i<=mid)
                    count ++;
            }
            if(count<=mid){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }

    /**
     * O(n)  链表成环
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
     int slow = nums[0], fast = nums[0];
     do {
         slow = nums[slow];
         fast = nums[nums[fast]];
     } while (slow != fast);
     int head = nums[0];
     while (head != slow) {
         head = nums[head];
         slow = nums[slow];
     }
     return head;

     }
}
