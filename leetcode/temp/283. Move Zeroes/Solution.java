



class Solution {


    public void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length-j; i++) {
            if (nums[i] == 0) {
                move(nums, i);
                j++;
                i--;
            }

        }


    }

    public void move(int[] nums, int index) {
        int temp = index;
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = 0;

    }


    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 12});

    }
	
	
	
	
	
	
    
    public void moveZeroes2(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }

}