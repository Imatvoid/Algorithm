class Solution {
//   public int removeDuplicates(int[] nums) {
//         int len = nums.length;
//        for(int i=0;i<nums.length-(nums.length-len);i++){
//            if(i-1>=0){

//                if(nums[i]==nums[i-1]){
//                    for(int j=i;j<nums.length-1;j++){
//                        nums[j]=nums[j+1];
//                    }
//                    nums[nums.length-1]=nums[i-1];
//                    i--;
//                    len--;
//                }
//            }
//        }
//        return len;



//     }
    public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
    }
}